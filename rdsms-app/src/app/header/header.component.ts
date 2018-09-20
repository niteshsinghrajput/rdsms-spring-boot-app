import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import { IUser } from '../user';
import { AuthService } from '../auth.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css'],
  providers: [AuthService]
})
export class HeaderComponent implements OnInit {

  public applicationName = 'RD Service Management System';
  public currentUser = {
                          'userName': 'nitesh'
                        };

  currentUser1: IUser;
  constructor(public authService: AuthService, public router: Router) {
    this.currentUser1 = JSON.parse(localStorage.getItem('currentUser'));
    console.log(this.currentUser);
  }


  ngOnInit() {
  }

  logOut() {
    this.authService.logOut()
      .subscribe(
        data => {
          this.router.navigate(['/login']);
        },
        error => {

        });
  }
}
