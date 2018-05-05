import { Component, OnInit } from '@angular/core';
import { MenuService } from '../menu.service';
import { IMenu } from '../menu';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css'],
  providers: [MenuService]
})
export class MenuComponent implements OnInit {

  public menuItems = [];
  public roleName = 'Admin';

  constructor(private menuService: MenuService) { }

  ngOnInit() {
    console.log('getting all menu items from json file for role : ' + this.roleName);
    this.menuService.getMenuList(this.roleName)
        .subscribe(data => this.menuItems = data);
  }

}
