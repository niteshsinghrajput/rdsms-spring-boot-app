import { Component, OnInit } from '@angular/core';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';
import { User } from '../models/model.user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthService]
})
export class LoginComponent implements OnInit {

  public applicationName = 'RD Service Management System';

  user: User = new User();
  errorMessage: string;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit() {
  }

  login() {
    this.authService.logIn(this.user)
      .subscribe(data => {
        this.router.navigate(['/user']);
        }, err => {
        this.errorMessage = 'error :  Username or password is incorrect';
        }
      );
  }

}
