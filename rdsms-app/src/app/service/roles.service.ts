import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IRole } from '../models/role';
import { AuthService } from './auth.service';
import { AppComponent } from '../app.component';



@Injectable()
export class RolesService {

  constructor(private http: Http, private service: AuthService) { }
  private endpoint = AppComponent.API_URL + '/rdsmsservice/roles';
  private options = this.service.getAuthHeaders();

  // create role
  createRole(role: IRole): Observable<number> {
    console.log('Create Role Called...');
    return this.http.post(this.endpoint, role, this.options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  // read role from backend
  getRoles(): Observable<IRole[]> {
    return this.http.get(this.endpoint, this.options)
          .map(this.extractData)
          .catch(this.handleError);

  }

  getRoleById(roleId: string): Observable<IRole> {
    return this.http.get(this.endpoint + '/' + roleId, this.options)
       .map(this.extractData)
       .catch(this.handleError);
  }

  updateRole(role: IRole): Observable<number> {
    return this.http.put(this.endpoint + '/' + role.roleId, role, this.options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteRoleById(roleId: string): Observable<number> {
    return this.http.delete(this.endpoint + '/' + roleId, this.options)
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

