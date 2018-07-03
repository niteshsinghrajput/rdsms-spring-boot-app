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

  createDirector(director) {
    console.log('Adding new Director into backend database..' + director);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json'});
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.endpoint, director, options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  updateDirector(director: IDirector): Observable<number> {
    console.log('updating director in backend..' + director);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.endpoint + '/' + director.directorId, director, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteDirector(directorId): Observable<number> {
    console.log('Deleting director [id = ' + directorId + '] from backend');
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.delete(this.endpoint + '/' + directorId)
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
