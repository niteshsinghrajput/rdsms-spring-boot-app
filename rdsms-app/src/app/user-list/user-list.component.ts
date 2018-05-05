import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { IUser } from '../user';


@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css'],
  providers: [UsersService]
})

export class UserListComponent implements OnInit {

  public users: IUser[] = [];
  selectedUser: IUser;
  public message: string;
  public displayMessage = true;

  constructor(private usersService: UsersService) { }

  onEdit(user) {
    console.log('onEdit function called...!!!');
    console.log(user);
    this.selectedUser = JSON.parse(JSON.stringify(user));
  }

  saveUserToList(event) {
    this.users.push(event.user);
    console.log('User has been added successfully..!!' + event.user.userName);
    this.displayAlert('User has been added successfully..!!');
  }

  updateUserList(event) {
    const msg = 'User [User Id=' + event.user.userId + '] has been updated successfully..!!!';
    console.log(msg);
    this.displayAlert(msg);
    for ( let idx = 0; idx < this.users.length; idx++) {
      const user = this.users[idx];
      if ( user.userId === event.user.userId) {
        this.users[idx] = event.user;
        break;
      }
    }
  }

  deleteUser(userId) {
    console.log('deleteUser called for User Id - ' + userId);
    this.usersService.deleteUserById(userId)
    .subscribe(successCode => {
      if (successCode === 200) {
        const msg = 'USer [UserId=' + userId + '] has been deleted successfully..!!!';
        console.log(msg);
        this.displayAlert(msg);
        for ( let idx = 0; idx < this.users.length; idx++) {
          const user = this.users[idx];
          if (user.userId === userId) {
              this.users.splice(idx, 1);
              break;
          }
        }
      }
    });
  }

  // display notification
  displayAlert(msg) {
    console.log('displayAlert called and msg is ... ' + msg);
    this.message = msg;
    setTimeout(() => {
      this.displayMessage = false;
      this.message = '';
    }, 5000);
  }

  ngOnInit() {
      console.log('Getting all users from backend...');
      this.displayMessage = true;
      this.usersService.getUsers()
      .subscribe(data => this.users = data);
    }
}

