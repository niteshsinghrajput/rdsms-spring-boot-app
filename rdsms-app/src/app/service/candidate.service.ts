import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { ICandidate } from '../models/candidate';
import { AuthService } from '../service/auth.service';
import { AppComponent } from '../app.component';

@Injectable()
export class CandidateService {

  constructor(private http: Http, private service: AuthService) { }
  private endpoint = AppComponent.API_URL + '/candidateservice';
  private options = this.service.getAuthHeaders();

  createCandidate(candidate) {
    console.log('Adding new candidate into backend database..' + candidate);
    return this.http.post(this.endpoint + '/candidates', candidate, this.options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  getAvailableCandidates() {
    console.log('Getting candidates from backend...!!');
    return this.http.get(this.endpoint + '/availablecandidates', this.options)
          .map(this.extractData)
          .catch(this.handleError);
  }

  getCandidates() {
      console.log('Getting candidates from backend...!!');
      return this.http.get(this.endpoint + '/candidates', this.options)
            .map(this.extractData)
            .catch(this.handleError);
  }

  updateCandidate(candidate: ICandidate): Observable<number> {
    console.log('updating candidate in backend..' + candidate);
    return this.http.put(this.endpoint + '/candidates/' + candidate.candidateId, candidate, this.options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteCandidate(candidateId): Observable<number> {
    console.log('Deleting candidate[id = ' + candidateId + '] from backend');
    return this.http.delete(this.endpoint + '/candidates/' + candidateId, this.options)
          .map(success => success.status)
          .catch(this.handleError);
  }

  private extractData(res: Response) {
      const body = res.json();
      return body;
  }

  private handleError (error: Response | any) {
    console.error(error.message || error);
    return Observable.throw(error);
    }
}
