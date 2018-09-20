import { Component, OnInit } from '@angular/core';
import { RolesService } from '../roles.service';
import { IRole } from '../role';
import { RoleFormComponent } from '../role-form/role-form.component';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-roles',
  templateUrl: './roles.component.html',
  styleUrls: ['./roles.component.css'],
  providers: [ RolesService ]
})

export class RolesComponent implements OnInit {

  public roles: IRole[] = [];
  selectedRole: IRole;
  public message: string;
  public displayMessage = true;

  onEdit(role) {
    console.log('onEdit function called...!!!');
    this.selectedRole = JSON.parse(JSON.stringify(role));
  }

  saveRoleToList(event) {
    this.roles.push(event.role);
    console.log('New Role Added to Role List..' + event.role.roleName);
    this.displayNotification('Role has been added successfully..!!');
  }

  updateRoleList(event) {
    const msg = 'Role [RoleId=' + event.role.roleId + '] has been updated successfully..!!!';
    console.log(msg);
    this.displayNotification(msg);
    for ( let idx = 0; idx < this.roles.length; idx++) {
      const role = this.roles[idx];
      if (role.roleId === event.role.roleId) {
        this.roles[idx] = event.role;
        break;
      }
    }
  }

  deleteRole(roleId) {
    console.log('deleteRole called for Role Id - ' + roleId);
    this.roleService.deleteRoleById(roleId)
    .subscribe(successCode => {
      if (successCode === 200) {
        const msg = 'Role [RoleId=' + roleId + '] has been deleted successfully..!!!';
        console.log(msg);
        this.displayNotification(msg);
        for ( let idx = 0; idx < this.roles.length; idx++) {
          const role = this.roles[idx];
          if (role.roleId === roleId) {
            this.roles.splice(idx, 1);
            break;
          }
        }
      }
    });
  }

  displayNotification(msg) {
    this.displayMessage = true;
    this.message = msg;
    setTimeout(() => {
      this.displayMessage = false;
    }, 3000);
  }

  constructor(private roleService: RolesService, public authService: AuthService, public router: Router) { }

  ngOnInit() {
    console.log('getting all roles from backend ...');
    this.displayMessage = false;
    this.roleService.getRoles()
        .subscribe(data => this.roles = data);
  }

}
