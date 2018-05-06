import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IBranch } from './branch';

@Injectable()
export class BranchService {

  constructor(private http: Http) { }
  private endpoint = 'http://localhost:8080/branchservice/branches';

  createBranch(branch: IBranch): Observable<number> {
    console.log('Creating new Branch...');
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.endpoint, branch, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  getBranches() {
    console.log('Getting Branches from Backend Service...');
    return this.http.get(this.endpoint)
            .map(this.extractData)
            .catch(this.handleError);
  }

  getBranchById(userId: string): Observable<IBranch> {
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    console.log(this.endpoint + '/' + userId);
    return this.http.get(this.endpoint + '/' + userId)
       .map(this.extractData)
       .catch(this.handleError);
  }

  updateBranch(branch: IBranch): Observable<number> {
    console.log('updating branch in backend..' + branch);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.endpoint + '/' + branch.branchId, branch, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteBranchById(branchId: string): Observable<number> {
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.delete(this.endpoint + '/' + branchId)
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
