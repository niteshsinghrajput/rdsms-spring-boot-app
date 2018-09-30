import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot } from '@angular/router';
import { AuthService } from './service/auth.service';

@Injectable()
export class RoleGuardService implements CanActivate {

    constructor(public auth: AuthService, public router: Router, private service: AuthService) {}

    canActivate(route: ActivatedRouteSnapshot): boolean {
        // this will be passed from the route config
        // on the data property
        const expectedRole = route.data.expectedRole;
        const username  =  JSON.parse(localStorage.getItem('currentUser'));
        const role = localStorage.getItem('currentRole');

        if ( username == null && role !== expectedRole) {
          this.router.navigate(['login']);
          return false;
        }
        return true;
      }

}
