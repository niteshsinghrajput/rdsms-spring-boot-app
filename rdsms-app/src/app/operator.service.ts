import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/observable';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IOperator } from './operator';

/**
 * @author Nitesh
 */

@Injectable()
export class OperatorService {

  constructor(private http: Http) { }
  private endpoint = 'http://localhost:8080/operatorservice/operators';

  getOperators(): Observable<IOperator[]> {
    return this.http.get(this.endpoint)
          .map(this.extractData)
          .catch(this.handleError);
  }

  createOperator(operator) {
    console.log('Adding new operator into backend database..' + operator);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json'});
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.endpoint, operator, options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  updateOperator(operator: IOperator): Observable<number> {
    console.log('updating operator in backend..' + operator);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.endpoint + '/' + operator.operatorId, operator, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteOperator(operatorId): Observable<number> {
    console.log('Deleting operator [id = ' + operatorId + '] from backend');
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.delete(this.endpoint + '/' + operatorId)
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
