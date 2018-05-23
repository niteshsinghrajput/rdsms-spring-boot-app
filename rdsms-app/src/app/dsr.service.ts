import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class DsrService {
  constructor(private http: Http) { }
  private endpoint = 'http://localhost:8080/dsrservice';

  getBsnlDsrData() {
    console.log('Getting Bsnl DSR Data from backend service...');
    return this.http.get(this.endpoint + '/dsrBsnl')
      .map(this.extractData)
      .catch(this.handleError);
  }

  uploadBsnlDsrData(file: File) {
    console.log('uploading bsnl dsr data ..' + file);
    // const cpHeaders = new Headers({ 'Content-Type': undefined });
    const headers = new Headers();
    const formData: FormData = new FormData();
    formData.append('fileName', file, file.name);

    // const cpHeaders = new Headers();
    // cpHeaders.append('Content-Type', 'multipart/form-data');
    const options = new RequestOptions({ headers: headers });
    return this.http.post(this.endpoint + '/dsrBsnl', formData, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  getVodafoneDsrData() {
    console.log('Getting Vodafone DSR Data from backend service...');
    return this.http.get(this.endpoint + '/dsrVodafone')
      .map(this.extractData)
      .catch(this.handleError);
  }

  uploadVodaDsrData(file: File) {
    console.log('uploading vodafone dsr data ..' + file);
    const headers = new Headers();
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);

    const options = new RequestOptions({ headers: headers });
    return this.http.post(this.endpoint + '/dsrVodafone', formData, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  private extractData(res: Response) {
    const body = res.json();
    // console.log('Response is : ' + JSON.stringify(body));
    return body;
  }

  private handleError (error: Response | any) {
  console.error(error.message || error);
  return Observable.throw(error.status);
  }

}
