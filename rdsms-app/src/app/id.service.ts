import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { ID } from './id';

@Injectable()
export class IdService {

  private endpoint = 'http://localhost:8080/idservice/id';
  constructor(private http: Http) { }

  createID(id) {
    console.log('Adding new ID into backend database..' + id);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json'});
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.endpoint, id, options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  getIDs() {
    console.log('Getting IDs from backend...!!');
    return this.http.get(this.endpoint)
          .map(this.extractData)
          .catch(this.handleError);
  }

  getAvailableIDs() {
    console.log('Getting Available IDs from backend..!!');
    return this.http.get('http://localhost:8080/idservice/availableid')
          .map(this.extractData)
          .catch(this.handleError);
  }

  updateID(id: ID): Observable<number> {
    console.log('updating ID in backend..' + id);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.endpoint + '/' + id.id, id, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteID(id): Observable<number> {
    console.log('Deleting ID [id = ' + id + '] from backend');
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.delete(this.endpoint + '/' + id)
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
