import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { AuthService } from '../service/auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  providers: [AuthService]
})
export class HeaderComponent implements OnInit {

  public applicationName = 'RD Service Management System';
  public currentUser =  JSON.parse(localStorage.getItem('currentUser'));

  constructor(public authService: AuthService, public router: Router) { }


  ngOnInit() {
  }

  logOut() {
    this.authService.logOut();
    this.router.navigate(['/login']);
  }
}
