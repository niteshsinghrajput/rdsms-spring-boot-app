import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/observable';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IOperator } from '../models/operator';
import { AppComponent } from '../app.component';
import { AuthService } from './auth.service';

/**
 * @author Nitesh
 */

@Injectable()
export class OperatorService {

  constructor(private http: Http, private service: AuthService) { }
  private endpoint = AppComponent.API_URL + '/operatorservice/operators';
  private options = this.service.getAuthHeaders();

  getOperators(): Observable<IOperator[]> {
    return this.http.get(this.endpoint, this.options)
          .map(this.extractData)
          .catch(this.handleError);
  }

  createOperator(operator) {
    console.log('Adding new operator into backend database..' + operator);
    return this.http.post(this.endpoint, operator, this.options)
    .map(success => success.status)
    .catch(this.handleError);
  }

  updateOperator(operator: IOperator): Observable<number> {
    console.log('updating operator in backend..' + operator);
    return this.http.put(this.endpoint + '/' + operator.operatorId, operator, this.options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteOperator(operatorId): Observable<number> {
    console.log('Deleting operator [id = ' + operatorId + '] from backend');
    return this.http.delete(this.endpoint + '/' + operatorId, this.options)
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
