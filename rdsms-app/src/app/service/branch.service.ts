import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { IBranch } from '../models/branch';
import { AuthService } from '../service/auth.service';
import { AppComponent } from '../app.component';
import { HttpErrorResponse } from '@angular/common/http';

@Injectable()
export class BranchService {

  constructor(private http: Http, private service: AuthService) { }

  private endpoint = AppComponent.API_URL + '/branchservice/branches';
  private options = this.service.getAuthHeaders();

  createBranch(branch: IBranch): Observable<IBranch> {
    console.log('Creating new Branch...');
    return this.http.post(this.endpoint, branch, this.options)
            // .map(success => success.status)
            .map(this.extractData)
            .catch(this.handleError);
  }

  getBranches() {
    console.log('Getting Branches from Backend Service...');
    return this.http.get(this.endpoint, this.options)
            .map(this.extractData)
            .catch(this.handleError);
  }

  getBranchById(userId: string): Observable<IBranch> {
    console.log(this.endpoint + '/' + userId);
    return this.http.get(this.endpoint + '/' + userId, this.options)
       .map(this.extractData)
       .catch(this.handleError);
  }

  updateBranch(branch: IBranch): Observable<IBranch> {
    console.log('updating branch in backend..' + branch);
    return this.http.put(this.endpoint + '/' + branch.branchId, branch, this.options)
            .map(this.extractData)
            .catch(this.handleError);
  }

  deleteBranchById(branchId: string): Observable<number> {
    return this.http.delete(this.endpoint + '/' + branchId, this.options)
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

    private handleError1 (error: HttpErrorResponse | any) {
      console.error(error.message || error);
      return Observable.throw(error.status || 500);
      }
  }

