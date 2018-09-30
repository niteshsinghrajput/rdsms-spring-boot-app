import { Component, OnInit } from '@angular/core';
import { IssueIdService } from '../service/issue-id.service';
import { IdAllocation } from '../models/id-allocation';

@Component({
  selector: 'app-issue-id-list',
  templateUrl: './issue-id-list.component.html',
  styleUrls: ['./issue-id-list.component.css'],
  providers: [IssueIdService]
})
export class IssueIdListComponent implements OnInit {

  allocatedIds: IdAllocation[];
  selectedId: IdAllocation;
  public message: string;
  public displayMessage = false;

  constructor(private service: IssueIdService) { }

  ngOnInit() {
    this.getAllocatedIds();
  }

  getAllocatedIds() {
    console.log('Getting allocated Ids from backend...');
    this.service.getAllocatedIDs().subscribe(data => this.allocatedIds = data);
  }

  addNewID() {
    console.log('Add New ID called..');
    this.selectedId = {
      'issueId': 0,
      'idd': { 'idNumber': '0' },
      'candidate': { 'candidateId': 0 },
      'createdBy': { 'userId': 0 },
      'updatedBy': { 'userId': 0 },
      'createdOn': new Date(),
      'updatedOn': new Date(),
      'active': true
    };
  }

  onIDEdit(id) {
    console.log('onIdEdit called..' + id.issueId);
    this.selectedId = JSON.parse(JSON.stringify(id));
    console.log('Selected ID is :: ' + this.selectedId.issueId);
  }

  deleteID(id) {

    console.log('deleteID called for Id - ' + id);
    this.service.deleteID(id)
    .subscribe(successCode => {
      if (successCode === 200) {
        const msg = 'ID [Id=' + id + '] has been deleted successfully..!!!';
        console.log(msg);
        this.displayAlert(msg);
        this.getAllocatedIds();
      }
    });
  }

  saveIdToList(event) {
    console.log('SaveToList :: ' + event.id);
    this.allocatedIds.push(event.id);
    const message = 'ID [id=' + event.id.idd.id + '] has been issued successfully..!!';
    this.getAllocatedIds();
    console.log(message);
    this.displayAlert(message);
  }

  updateIdList(event) {
    console.log('updateIdList :: ' + event.id);
    const message = 'ID [issueId=' + event.id.issueId + '] has been updated successfully..!!';
    console.log(message);
    this.getAllocatedIds();
    this.displayAlert(message);
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
