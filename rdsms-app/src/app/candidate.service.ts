import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { ICandidate } from './candidate';

@Injectable()
export class CandidateService {

  constructor(private http: Http) { }
  private endpoint = 'http://localhost:8080/candidateservice/candidates';

  createCandidate(candidate) {
    console.log('Adding new candidate into backend database..' + candidate);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json'});
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.post(this.endpoint, candidate, options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  getAvailableCandidates() {
    console.log('Getting candidates from backend...!!');
    return this.http.get('http://localhost:8080/candidateservice/availablecandidates')
          .map(this.extractData)
          .catch(this.handleError);
  }

  getCandidates() {
      console.log('Getting candidates from backend...!!');
      return this.http.get(this.endpoint)
            .map(this.extractData)
            .catch(this.handleError);
  }

  updateCandidate(candidate: ICandidate): Observable<number> {
    console.log('updating candidate in backend..' + candidate);
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.put(this.endpoint + '/' + candidate.candidateId, candidate, options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteCandidate(candidateId): Observable<number> {
    console.log('Deleting candidate[id = ' + candidateId + '] from backend');
    const cpHeaders = new Headers({ 'Content-Type': 'application/json' });
    const options = new RequestOptions({ headers: cpHeaders });
    return this.http.delete(this.endpoint + '/' + candidateId)
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
