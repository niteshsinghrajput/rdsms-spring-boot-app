import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { Observable } from 'rxjs/observable';
import { HttpClient } from '@angular/common/http';
import { IDirector } from '../models/director';
import { AuthService } from '../service/auth.service';
import { AppComponent } from '../app.component';

@Injectable()
export class DirectorService {

  constructor(private http: Http, private service: AuthService) { }

  private endpoint = AppComponent.API_URL + '/directorservice/directors';
  private options = this.service.getAuthHeaders();

  getDirectors() {
    console.log('Getting list of directors from backend service...');
    return this.http.get(this.endpoint, this.options)
      .map(this.extractData)
      .catch(this.handleError);
  }

  createDirector(director) {
    console.log('Adding new Director into backend database..' + director);
    return this.http.post(this.endpoint, director, this.options)
    .map(success => success.status)
    .catch(this.handleError);

  }

  updateDirector(director: IDirector): Observable<number> {
    console.log('updating director in backend..' + director);
    return this.http.put(this.endpoint + '/' + director.directorId, director, this.options)
            .map(success => success.status)
            .catch(this.handleError);
  }

  deleteDirector(directorId): Observable<number> {
    console.log('Deleting director [id = ' + directorId + '] from backend');
    return this.http.delete(this.endpoint + '/' + directorId, this.options)
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
