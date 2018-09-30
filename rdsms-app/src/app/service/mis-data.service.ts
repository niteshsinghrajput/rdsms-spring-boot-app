import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IMis } from '../models/mis';
import { AppComponent } from '../app.component';
import { AuthService } from './auth.service';

@Injectable()
export class MisDataService {

  constructor(private http: Http, private service: AuthService) { }
  private endpoint = AppComponent.API_URL + '/misservice/mis';
  private options = this.service.getAuthHeaders();
  // upload excel mis file

  getMisData(): Observable<IMis[]> {
    console.log('Getting MIS Data from Backend...');
    return this.http.get(this.endpoint, this.options)
    .map(this.extractData)
    .catch(this.handleError);
  }

  uploadMISData(file: File) {
    console.log('uploading MIS Data ..' + file);
    const headers = new Headers();
    const formData: FormData = new FormData();
    formData.append('file', file, file.name);
    const options = new RequestOptions({ headers: headers });
    return this.http.post(this.endpoint, formData, options)
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
