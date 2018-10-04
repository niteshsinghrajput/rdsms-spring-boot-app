import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { IdAllocation } from '../models/id-allocation';
import { AuthService } from '../service/auth.service';
import { AppComponent } from '../app.component';

@Injectable()
export class IssueIdService {

  constructor(private http: Http, private service: AuthService) { }

  private endpoint = AppComponent.API_URL + '/idservice';
  private options = this.service.getAuthHeaders();

  issueID(allocateId) {
    console.log('Assigning ID to candidate...' + allocateId);
    return this.http.post(this.endpoint + '/allocateid', allocateId, this.options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  getAllocatedIDs() {
    console.log('Getting allocated IDs from backend...!!');
    return this.http.get(this.endpoint + '/allocatedid', this.options)
          .map(this.extractData)
          .catch(this.handleError);
  }

  updateAllocatedId(id: IdAllocation) {
    console.log('updateAllocatedId called...');
    return this.http.put(this.endpoint + '/allocatedid/' + id.issueId, id, this.options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteID(id): Observable<number> {
    console.log('Deleting Allocated [id = ' + id + '] from backend');
    return this.http.delete(this.endpoint + '/deallocateid' + '/' + id, this.options)
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
