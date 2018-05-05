import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { HttpClient } from '@angular/common/http';
import { IBranch } from './branch';

@Injectable()
export class BranchService {

  constructor(private http: HttpClient) { }
  private endpoint = 'http://localhost:8080/branchservice/branches';

  getBranches() {
    console.log('Getting Branches from Backend Service...');
    return this.http.get<IBranch[]>(this.endpoint);
  }

}
