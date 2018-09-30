import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/observable';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IOperatorType } from '../models/operatortype';
import { AppComponent } from '../app.component';
import { AuthService } from './auth.service';

/**
 * @author Nitesh
 */

@Injectable()
export class OperatortypeService {

  constructor(private http: Http, private service: AuthService) { }
  private endpoint = AppComponent.API_URL + '/operatorservice/operatortypes';
  private options = this.service.getAuthHeaders();

  getOperatorTypeList(): Observable<IOperatorType[]> {
    console.log(this.endpoint);
    return this.http.get(this.endpoint, this.options)
          .map(this.extractData)
          .catch(this.handleError);
  }

  createOperatorType(operatorType) {
    console.log('Adding new operatorType into backend database..' + operatorType);
    return this.http.post(this.endpoint, operatorType, this.options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  updateOperatorType(operatorType: IOperatorType): Observable<number> {
    console.log('updating operatorType in backend..' + JSON.stringify(operatorType));
    return this.http.put(this.endpoint + '/' + operatorType.operatorTypeId, operatorType, this.options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteOperatorType(operatorTypeId): Observable<number> {
    console.log('Deleting operatorType [id = ' + operatorTypeId + '] from backend');
    return this.http.delete(this.endpoint + '/' + operatorTypeId, this.options)
          .map(success => success.status)
          .catch(this.handleError);
  }

  private extractData(res: Response) {
    const body = res.json();
    console.log('Operator Types ..' + JSON.stringify(body));
    return body;
  }

  private handleError (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error.status);
  }

}
