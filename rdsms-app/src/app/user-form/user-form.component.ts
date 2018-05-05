import { Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';
import { IUser } from '../user';
import { UsersService } from '../users.service';
import { IRole } from '../role';
import { RolesService } from '../roles.service';

@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {

  public title_add = 'Add New User';
  public title_update = 'Update User Detail';
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input()
  user: IUser;

  @Output()
  userUpdated = new EventEmitter();

  @Output()
  userAdded = new EventEmitter();

  public roles: IRole[];
  public selectedRoles: IRole[];

  addUser() {
    console.log('addUser called...!!!');
    console.log(JSON.stringify(this.user));
    const userData = JSON.parse(JSON.stringify(this.user));
    if (userData.active === 'false') {
      userData.active = false;
    } else {
      userData.active = true;
    }

    console.log('Before creating new User...');
    console.log(userData);
    this.userService.createUser(userData)
    .subscribe(successCode => {
        if (successCode === 200) {
          console.log('User (' + userData + ') has been added Successfully..!!');
          console.log(userData);
          this.userAdded.emit({ user: userData });
          this.closeModal();
        }
    });

  }


  updateUser() {
    console.log('updateUser called...!!!' + JSON.stringify(this.user));
    const userData = JSON.parse(JSON.stringify(this.user));
    if (userData.active === 'true') {
      userData.active = true;
    } else {
      userData.active = false;
    }
    console.log('Before sending data to update in db...');
    console.log(userData);
    this.userService.updateUser(userData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('User with ID = ' + userData.userId + ' has been updated Successfully..!!');
        console.log(userData);
        this.userUpdated.emit({ user: userData });
        this.closeModal();
      }
    });
  }

  constructor(private userService: UsersService, private roleService: RolesService) { }

  ngOnInit() {
      console.log('ngOnInit called...!!!');
      this.user = {
          'userId': 0,
          'name': 'Enter Name',
          'email': 'Enter Email',
          'userName': 'Enter Username',
          'password': 'Enter Password',
          'mobile': 'Enter Mobile',
          'address': 'Enter Address',
          'city': 'Enter City',
          'district': 'Enter District',
          'postalCode': 'Enter Postal Code',
          'roles': [
              {
                  'roleId': 0,
                  'roleName': 'admin',
                  'description': 'desc',
                  'active': true
              }
          ],
          'active': true
      };

      this.roleService.getRoles()
      .subscribe(data => this.roles = data);

    }

  private closeModal(): void {
      this.closeBtn.nativeElement.click();
      this.user = {
        'userId': 0,
        'name': 'Enter Name',
        'email': 'Enter Email',
        'userName': 'Enter Username',
        'password': 'Enter Password',
        'mobile': 'Enter Mobile',
        'address': 'Enter Address',
        'city': 'Enter City',
        'district': 'Enter District',
        'postalCode': 'Enter Postal Code',
        'roles': [
            {
                'roleId': 0,
                'roleName': 'admin',
                'description': 'desc',
                'active': true
            }
        ],
        'active': true
    };
  }

}
