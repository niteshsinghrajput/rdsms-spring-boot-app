import { Injectable } from '@angular/core';
import { Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/observable';
import { ICandidate } from './candidate';

@Injectable()
export class CandidateService {

  constructor(private http: HttpClient) { }
  private endpoint = 'http://localhost:8080/candidateservice/candidates';

  getCandidates() {
      console.log('Getting candidates from backend...!!');
      console.log('Endpoint : ' + this.endpoint);
      return this.http.get<ICandidate[]>(this.endpoint);
  }

}
