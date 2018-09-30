import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { AuthService } from '../service/auth.service';
import { AppComponent } from '../app.component';

@Injectable()
export class DsrService {
  constructor(private http: Http, private service: AuthService) { }

  private endpoint = AppComponent.API_URL + '/dsrservice';
  private options = this.service.getAuthHeaders();

  getBsnlDsrData() {
    console.log('Getting Bsnl DSR Data from backend service...');
    return this.http.get(this.endpoint + '/dsrBsnl', this.options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  uploadBsnlDsrData(file: File) {
    console.log('uploading bsnl dsr data ..' + file);
    const formData: FormData = new FormData();
    formData.append('fileName', file, file.name);
    return this.http.post(this.endpoint + '/dsrBsnl', formData, this.options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  getVodafoneDsrData() {
    console.log('Getting Vodafone DSR Data from backend service...');
    return this.http.get(this.endpoint + '/dsrVodafone', this.options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  uploadVodaDsrData(file: File) {
    console.log('uploading vodafone dsr data ..' + file);
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    return this.http.post(this.endpoint + '/dsrVodafone', formData, this.options)
      .map(success => success.status)
      .catch(this.handleError);
  }

  private extractData(res: Response) {
    const body = res.json();
    return body;
  }

  private handleError (error: Response | any) {
  console.error(error.message || error);
  return Observable.throw(error.status);
  }

}
