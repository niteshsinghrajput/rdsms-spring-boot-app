import { Component, OnInit } from '@angular/core';
import { IssueIdService } from '../issue-id.service';
import { IdAllocation } from '../id-allocation';

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

  allocateId() {
    console.log('AllocateId called..');
  }

  deallocateId() {
    console.log('DeallocateId called..');
  }

}
