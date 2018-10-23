import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import {AppComponent} from '../app.component';
import { Observable } from 'rxjs/observable';
import { User } from '../models/model.user';

@Injectable()
export class AuthService {

  constructor(private http: Http) { }

  userLogin(user) {
    console.log('Login request..' + JSON.stringify(user));
    const cpHeaders = new Headers({ 'Content-Type': 'application/json'});
    const options = new RequestOptions({ headers: cpHeaders });
    const userLoginPayload = {
      'usernameOrEmail': user.userName,
      'password': user.password
    };
    console.log('user payload :: ' + JSON.stringify(userLoginPayload));
    return this.http.post(AppComponent.API_URL + '/api/auth/signin', userLoginPayload, options)
    .map((response: Response) => {

      const user1 = response.json(); // the returned user object is a principal object
      if (user1) {
        // store user details  in local storage to keep user logged in between page refreshes
        localStorage.setItem('currentUser', JSON.stringify(user.userName));
        localStorage.setItem('authToken', JSON.stringify(user1) );
        console.log('User Details :: ' + localStorage.getItem('currentUser'));
        console.log('JWT Details :: ' + localStorage.getItem('authToken'));
      }
    })
    .catch(this.handleError);

  }

  getUserRole() {
    const email = JSON.parse(localStorage.getItem('currentUser'));
    return this.http.get(AppComponent.API_URL + '/rdsmsservice/users/roles/' +
    email.trim(), this.getAuthHeaders())
    .map(this.extractData)
    .catch(this.handleError);
  }

  logOut() {
    // remove user from local storage to log user out
    console.log('clearing local storage.. ');
    localStorage.removeItem('currentUser');
    localStorage.removeItem('authToken');
    localStorage.clear();
    return this.http.post(AppComponent.API_URL + 'logout', {})
      .map((response: Response) => {
        localStorage.removeItem('currentUser');
        localStorage.removeItem('authToken');
      });

  }

private extractData(res: Response) {
    const body = res.json();
    console.log('hello ::', JSON.stringify(body));
    return body;
}

private handleError (error: Response | any) {
  console.error(error.message || error);
  return Observable.throw(error.status);
}

getAuthHeaders() {
  const authToken = JSON.parse(localStorage.getItem('authToken'));
  const cpHeaders = new Headers({ 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + authToken.accessToken });
  const options = new RequestOptions({ headers: cpHeaders });
  return options;
}

}
