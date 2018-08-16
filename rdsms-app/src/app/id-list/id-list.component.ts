import { Component, OnInit } from '@angular/core';
import { ID } from '../id';
import { IdService } from '../id.service';

@Component({
  selector: 'app-id-list',
  templateUrl: './id-list.component.html',
  styleUrls: ['./id-list.component.css'],
  providers: [IdService]
})
export class IdListComponent implements OnInit {

  ids: ID[];
  selectedId: ID;
  public message: string;
  public displayMessage = false;

  constructor(private idService: IdService) { }

  addNewID() {
    console.log('Add New ID called..');
    this.selectedId = {

      'id': 0,
      'idNumber': 'Enter ID Number',
      'mobile': 'Enter Mobile Number',
      'operator': 'Select Operator',
      'rdbranch': 'Select Branch',
      'createdBy': { 'userId': 0 },
      'updatedBy': { 'userId': 0 },
      'createdOn': new Date(),
      'updatedOn': new Date(),
      'active': false

    };
  }

  onIDEdit(id) {
    console.log('onIdEdit called..' + id.id);
    this.selectedId = JSON.parse(JSON.stringify(id));
    console.log('Selected ID is :: ' + this.selectedId.id);
  }

  saveIdToList(event) {
    this.ids.push(event.id);
    const message = 'ID [' + event.id.idNumber + '] has been added successfully..!!';
    this.getIDs();
    console.log(message);
    this.displayAlert(message);
  }

  updateIdList(event) {
    const message = 'ID [' + event.id.idNumber + '] has been updated successfully..!!';
    console.log(message);
    this.getIDs();
    this.displayAlert(message);
  }

  deleteID(id) {

    console.log('deleteID called for Id - ' + id);
    this.idService.deleteID(id)
    .subscribe(successCode => {
      if (successCode === 200) {
        const msg = 'ID [Id=' + id + '] has been deleted successfully..!!!';
        console.log(msg);
        this.displayAlert(msg);
        this.getIDs();
      }
    });
  }

  getIDs() {
    console.log('Getting list of IDs from Service..');
    this.idService.getIDs().subscribe(data => this.ids = data);
  }
  ngOnInit() {
    this.getIDs();
  }

  // display notification
  displayAlert(msg) {
    this.displayMessage = true;
    console.log('displayAlert called and msg is ... ' + msg);
    this.message = msg;
    setTimeout(() => {
      this.displayMessage = false;
      this.message = '';
    }, 5000);
  }

}
