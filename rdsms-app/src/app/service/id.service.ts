import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { ID } from '../models/id';
import { AuthService } from '../service/auth.service';
import { AppComponent } from '../app.component';

@Injectable()
export class IdService {

  constructor(private http: Http, private service: AuthService) { }

  private endpoint = AppComponent.API_URL + '/idservice';
  private options = this.service.getAuthHeaders();

  createID(id) {
    console.log('Adding new ID into backend database..' + id);
    return this.http.post(this.endpoint + '/id', id, this.options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  getIDs() {
    console.log('Getting IDs from backend...!!');
    return this.http.get(this.endpoint + '/id', this.options)
          .map(this.extractData)
          .catch(this.handleError);
  }

  getAvailableIDs() {
    console.log('Getting Available IDs from backend..!!');
    return this.http.get(this.endpoint + '/availableid', this.options)
          .map(this.extractData)
          .catch(this.handleError);
  }

  updateID(id: ID): Observable<number> {
    console.log('updating ID in backend..' + id);
    return this.http.put(this.endpoint + '/id/' + id.id, id, this.options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteID(id): Observable<number> {
    console.log('Deleting ID [id = ' + id + '] from backend');
    return this.http.delete(this.endpoint + '/id/' + id, this.options)
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
