import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { IdAllocation } from './id-allocation';

@Injectable()
export class IssueIdService {

  private endpoint = 'http://localhost:8080/idservice/';
  constructor(private http: Http) { }

  issueID(allocateId) {
    console.log('Assigning ID to candidate...' + allocateId);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json'});
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.endpoint + 'allocateid', allocateId, options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  getAllocatedIDs() {
    console.log('Getting allocated IDs from backend...!!');
    return this.http.get(this.endpoint + 'allocatedid')
          .map(this.extractData)
          .catch(this.handleError);
  }

  updateAllocatedId() {
    console.log('updateAllocatedId called...');
  }

  deallocateId() {
    console.log('DeallocateId called..');
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
