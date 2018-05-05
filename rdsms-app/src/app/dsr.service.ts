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

  getVodafoneDsrData() {
    console.log('Getting Vodafone DSR Data from backend service...');
    return this.http.get(this.endpoint + '/dsrVodafone')
      .map(this.extractData)
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
