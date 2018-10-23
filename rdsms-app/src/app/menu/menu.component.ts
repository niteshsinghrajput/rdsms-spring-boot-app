import { Component, OnInit } from '@angular/core';
import { MenuService } from '../service/menu.service';
import { IMenu } from '../models/menu';
import { AuthService } from '../service/auth.service';
import { AppComponent } from '../app.component';
import { IRole } from '../models/role';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
  providers: [MenuService]
})
export class MenuComponent implements OnInit {

  public menuItems = [];
  public roles: IRole[];
  public roleName; // = JSON.parse(localStorage.getItem('currentRole'));
  constructor(private menuService: MenuService, private service: AuthService) { }

  ngOnInit() {

    this.service.getUserRole().subscribe( data => {
      this.roles = data;
      this.roleName = this.roles[0].roleName;
      console.log('RoleName : ', this.roleName);
      localStorage.setItem('currentRole', this.roleName);
    });

    // this.roleName = this.roles[0].roleName;
    console.log('getting all menu items from json file for role : ' + localStorage.getItem('currentRole'));

    this.menuService.getMenuList(localStorage.getItem('currentRole'))
        .subscribe(data => this.menuItems = data);
  }

}
