import { Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';
import { IRole } from '../role';
import { RolesService } from '../roles.service';

@Component({
  selector: 'app-role-form',
  templateUrl: './role-form.component.html',
  styleUrls: ['./role-form.component.css'],
  providers: [ RolesService ]
})
export class RoleFormComponent implements OnInit {

  public title_add = 'Add New Role';
  public title_update = 'Update Role Detail';
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input()
  role: IRole;

  @Output()
  roleUpdated = new EventEmitter();

  @Output()
  roleAdded = new EventEmitter();


  log(x) {
    console.log(x);
  }

  addRole() {
    console.log('addRole called...!!!');
    console.log(JSON.stringify(this.role));
    const roleData = JSON.parse(JSON.stringify(this.role));
    if (roleData.active === 'false') {
      roleData.active = false;
    } else {
      roleData.active = true;
    }

    console.log('Before creating new Role...');
    console.log(roleData);
    this.roleService.createRole(roleData)
    .subscribe(successCode => {
        if (successCode === 200) {
          console.log('Role (' + roleData + ') has been added Successfully..!!');
          console.log(roleData);
          this.roleAdded.emit({ role: roleData });
          this.closeModal();
        }
    });

  }


  updateRole() {
    console.log('updateRole called...!!!' + JSON.stringify(this.role));
    const roleData = JSON.parse(JSON.stringify(this.role));
    if (roleData.active === 'true') {
      roleData.active = true;
    } else {
      roleData.active = false;
    }
    console.log('Before sending data to update in db...');
    console.log(roleData);
    this.roleService.updateRole(roleData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('Role with ID = ' + roleData.roleId + ' has been updated Successfully..!!');
        console.log(roleData);
        this.roleUpdated.emit({ role: roleData });
        this.closeModal();
      }
    });
  }

   constructor(private roleService: RolesService) { }

  ngOnInit() {
      console.log('ngOnInit called...!!!');
      this.role = {
        roleId: 0,
        roleName: 'Enter Role..',
        description: 'Enter Role Description..',
        active: true
      };
    }

  private closeModal(): void {
      this.closeBtn.nativeElement.click();
      this.role = {
        roleId: 0,
        roleName: 'Enter Role..',
        description: 'Enter Role Description..',
        active: true
      };
  }

  }

