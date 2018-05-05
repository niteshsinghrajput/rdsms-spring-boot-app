import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { HttpClient } from '@angular/common/http';
import { IDirector } from './director';


@Injectable()
export class DirectorService {

  constructor(private http: Http) { }
  private endpoint = 'http://localhost:8080/directorservice/directors';

  getDirectors() {
    console.log('Getting list of directors from backend service...');
    return this.http.get(this.endpoint)
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
