import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IUser } from './user';

@Injectable()
export class UsersService {

  constructor(private http: Http) { }
  // private endpoint = '/assets/data/users.json';
  private endpoint = 'http://localhost:8080/rdsmsservice/users';

  createUser(role: IUser): Observable<number> {
    console.log('Create User Called...');
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.endpoint, role, options)
            .map(success => success.status)
            .catch(this.handleError);
    }

    // read role from backend
    getUsers(): Observable<IUser[]> {
      return this.http.get(this.endpoint)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getUserById(userId: string): Observable<IUser> {
      const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
      const options = new RequestOptions({ headers: cpHeaders });
      console.log(this.endpoint + '/' + userId);
      return this.http.get(this.endpoint + '/' + userId)
         .map(this.extractData)
         .catch(this.handleError);
    }

    updateUser(user: IUser): Observable<number> {
      console.log('updating user in backend..');
      const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
      const options = new RequestOptions({ headers: cpHeaders });
      return this.http.put(this.endpoint + '/' + user.userId, user, options)
              .map(success => success.status)
              .catch(this.handleError);
    }

    deleteUserById(userId: string): Observable<number> {
      const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
      const options = new RequestOptions({ headers: cpHeaders });
      return this.http.delete(this.endpoint + '/' + userId)
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
