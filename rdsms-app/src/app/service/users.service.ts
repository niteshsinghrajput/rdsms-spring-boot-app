import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IUser } from '../models/user';
import { AuthService} from './auth.service';
import { AppComponent } from '../app.component';

@Injectable()
export class UsersService {

  constructor(private http: Http, private service: AuthService) { }
  private endpoint = AppComponent.API_URL + '/rdsmsservice/users';
  private options = this.service.getAuthHeaders();

  createUser(role: IUser): Observable<number> {
    return this.http.post(this.endpoint, role, this.options)
            .map(success => success.status)
            .catch(this.handleError);
    }

    // read role from backend
    getUsers(): Observable<IUser[]> {
      return this.http.get(this.endpoint, this.options)
            .map(this.extractData)
            .catch(this.handleError);
    }

    getUserById(userId: string): Observable<IUser> {
      console.log(this.endpoint + '/' + userId);
      return this.http.get(this.endpoint + '/' + userId, this.options)
         .map(this.extractData)
         .catch(this.handleError);
    }

    updateUser(user: IUser): Observable<number> {
      return this.http.put(this.endpoint + '/' + user.userId, user, this.options)
              .map(success => success.status)
              .catch(this.handleError);
    }

    deleteUserById(userId: string): Observable<number> {
      return this.http.delete(this.endpoint + '/' + userId, this.options)
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
