import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IRole } from './role';



@Injectable()
export class RolesService {

  constructor(private http: Http) { }
  private endpoint = 'http://localhost:8080/rdsmsservice/roles';
   // private endpoint = '/assets/data/roles.json';

  // create role
  createRole(role: IRole): Observable<number> {
    console.log('Create Role Called...');
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.endpoint, role, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  // read role from backend
  getRoles(): Observable<IRole[]> {
    return this.http.get(this.endpoint)
          .map(this.extractData)
          .catch(this.handleError);

  }

  getRoleById(roleId: string): Observable<IRole> {
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    console.log(this.endpoint + '/' + roleId);
    return this.http.get(this.endpoint + '/' + roleId)
       .map(this.extractData)
       .catch(this.handleError);
  }

  updateRole(role: IRole): Observable<number> {
    console.log('updating role in backend..');
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.endpoint + '/' + role.roleId, role, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteRoleById(roleId: string): Observable<number> {
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.delete(this.endpoint + '/' + roleId)
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

