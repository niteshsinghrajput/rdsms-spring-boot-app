import { Injectable } from '@angular/core';
import {Http, Headers, RequestOptions, RequestMethod, Response } from '@angular/http';
import { HttpClient } from '@angular/common/http';
import { IMenu } from './menu';

@Injectable()
export class MenuService {

  constructor(private http: HttpClient) { }

  private endpoint;

  getMenuList(roleName: string) {
     console.log('MenuService :: Getting menu items for role : ' + roleName);
     if (roleName === 'Admin') {
        this.endpoint = '/assets/data/menu_admin.json';
     } else if (roleName === 'Candidate') {
       this.endpoint = '/assets/data/menu_candidates.json';
     }
     console.log('Endpoint :: ' + this.endpoint);
     return this.http.get<IMenu[]>(this.endpoint);
    }

}
