import { Component, OnInit, Input, Output, ViewChild, ElementRef, EventEmitter } from '@angular/core';
import { DatePipe } from '@angular/common';
import { IdAllocation } from '../models/id-allocation';
import { ID } from '../models/id';
import { ICandidate } from '../models/candidate';
import { IdService } from '../service/id.service';
import { CandidateService } from '../service/candidate.service';
import { IssueIdService } from '../service/issue-id.service';

@Component({
  selector: 'app-issue-id-form',
  templateUrl: './issue-id-form.component.html',
  styleUrls: ['./issue-id-form.component.css'],
  providers: [IssueIdService, IdService, CandidateService, DatePipe]
})
export class IssueIdFormComponent implements OnInit {

  public title_add = 'Issue ID';
  public title_update = 'Update IssuedID Detail';
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input()
  allocatedId: IdAllocation;

  @Output()
  idUpdated = new EventEmitter();

  @Output()
  idAdded = new EventEmitter();

  public ids: ID[];
  public selectedId: ID;
  public candidates: ICandidate[];
  public selectedCandidate: ICandidate;

  defaultIssueId = {
    'issueId': 0,
    'idd': { 'idNumber': '0' },
    'candidate': { 'candidateId': 0 },
    'createdBy': { 'userId': 0 },
    'updatedBy': { 'userId': 0 },
    'createdOn': new Date(),
    'updatedOn': new Date(),
    'active': true
  };


  constructor(private issueIdService: IssueIdService, private idService: IdService,
    private candidateService: CandidateService, public datepipe: DatePipe) { }

  ngOnInit() {
    this.allocatedId = this.defaultIssueId;
    this.idService.getAvailableIDs().subscribe(data => this.ids = data);
    this.candidateService.getAvailableCandidates().subscribe(data => this.candidates = data);
  }

  addID() {
    console.log('addID called..');
    console.log(JSON.stringify(this.allocatedId));

    const allocatedIdData = JSON.parse(JSON.stringify(this.allocatedId));
    allocatedIdData.updatedBy = {'userId': 3};
    allocatedIdData.createdBy = {'userId': 3};
    allocatedIdData.createdOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    allocatedIdData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');

    const candidateData  =  { 'candidateId': allocatedIdData.candidate };
    allocatedIdData.candidate = candidateData;

    const idData = { 'id': allocatedIdData.idd};
    allocatedIdData.idd = idData;

    console.log('Hiii... ' + JSON.stringify(idData));
    if (allocatedIdData.active === 'false') {
      allocatedIdData.active = false;
    } else {
      allocatedIdData.active = true;
    }

    console.log('Hii final allocated data before sending to backend...');
    console.log(JSON.stringify(allocatedIdData));

    this.issueIdService.issueID(allocatedIdData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('ID (' + allocatedIdData + ') has been issued Successfully...!!');
        this.idAdded.emit({ id: allocatedIdData });
        this.closeModal();
      }
    });
  }

  updateID() {

    const allocatedIdData = JSON.parse(JSON.stringify(this.allocatedId));
    allocatedIdData.updatedBy = {'userId': this.allocatedId.updatedBy.userId};
    allocatedIdData.createdBy = {'userId': this.allocatedId.createdBy.userId};
    allocatedIdData.createdOn = this.allocatedId.createdOn;
    allocatedIdData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');

    const candidateData  =  { 'candidateId': allocatedIdData.candidate };
    allocatedIdData.candidate = candidateData;

    const idData = { 'id': allocatedIdData.idd};
    allocatedIdData.idd = idData;

    if (allocatedIdData.active === 'false') {
      allocatedIdData.active = false;
    } else {
      allocatedIdData.active = true;
    }

    console.log('Update ID called ');
    console.log(JSON.stringify(allocatedIdData));

    this.issueIdService.updateAllocatedId(allocatedIdData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('ID (issueId=' + allocatedIdData.issueId + ') has been updated Successfully...!!');
        this.idUpdated.emit({ id: allocatedIdData });
        this.closeModal();
      }
    });
  }


  private closeModal(): void {
    this.closeBtn.nativeElement.click();
    this.allocatedId = this.defaultIssueId;
  }


}
