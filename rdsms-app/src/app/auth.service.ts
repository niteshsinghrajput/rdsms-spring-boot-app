import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import {AppComponent} from './app.component';
import { User } from './models/model.user';

@Injectable()
export class AuthService {

  constructor(private http: Http) { }

  public logIn(user: User) {
    console.log('Hiii :: ' + JSON.stringify(user));
    const headers = new Headers();
    headers.append('Accept', 'application/json');
    // creating base64 encoded String from user name and password
    const base64Credential: string = btoa( user.userName + ':' + user.password);
    headers.append('Authorization', 'Basic ' + [base64Credential]);

    const options = new RequestOptions();
    options.headers = headers;

    return this.http.get(AppComponent.API_URL + '/account/login',  options)
      .map((response: Response) => {
      // login successful if there's a jwt token in the response
      const user1 = response.json().principal; // the returned user object is a principal object
      if (user1) {
        // store user details  in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user));
      }
    });
  }

  logOut() {
    // remove user from local storage to log user out
    return this.http.post(AppComponent.API_URL + 'logout', {})
      .map((response: Response) => {
        localStorage.removeItem('currentUser');
      });

  }

}
