import { Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';
import { ICandidate } from '../models/candidate';
import { IBranch } from '../models/branch';
import { CandidateService } from '../service/candidate.service';
import { BranchService } from '../service/branch.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-candidate-form',
  templateUrl: './candidate-form.component.html',
  styleUrls: ['./candidate-form.component.css'],
  providers: [CandidateService, BranchService, DatePipe]
})
export class CandidateFormComponent implements OnInit {

  public title_add = 'Add New Candidate';
  public title_update = 'Update Candidate Detail';
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input()
  candidate: ICandidate;

  @Output()
  candidateUpdated = new EventEmitter();

  @Output()
  candidateAdded = new EventEmitter();

  public branches: IBranch[] = null;
  public selectedBranch: IBranch = null;

  defaultCandidate: ICandidate = {
    'candidateId': 0,
    'name': 'Enter Name ', 'fatherName': 'Enter Father Name', 'motherName': 'Enter Mother Name',
    'dob': new Date(), 'address': 'Enter Address', 'landmark': 'Enter Landmark',
    'city': 'Enter City', 'district': 'Enter District', 'state': 'Enter State',
    'postalCode': 'Enter Postal Code', 'religion': 'Enter Religion', 'category': 'Enter Category',
    'nationality': 'Enter Nationality', 'knownLanguages': 'Enter Known Language',
    'primaryMobile': 'Enter primary mobile', 'alternateMobile': 'Enter alternate mobile',
    'photoId': 0, 'bank': 'Enter Bank', 'branch': 'Enter Branch', 'ifscCode': 'Enter IFSC',
    'accountNumber': 'Enter Account', 'createdOn': new Date(), 'updatedOn': new Date(),
    'createdBy': { 'userId': 0 }, 'updatedBy': { 'userId': 0 }, 'rdbranch': {'branchId': 0}, 'active': true
    };

  constructor(private candidateService: CandidateService, private branchService: BranchService, public datepipe: DatePipe) { }

  ngOnInit() {
    this.branchService.getBranches().subscribe(data => this.branches = data);
     this.candidate = this.defaultCandidate;
        console.log(this.branches);

  }

  addCandidate() {
    console.log('Add candidate called ');
    console.log(JSON.stringify(this.candidate));
    const candidateData = JSON.parse(JSON.stringify(this.candidate));
    candidateData.updatedBy = {'userId': 3};
    candidateData.createdBy = {'userId': 3};
    candidateData.createdOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    candidateData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    const rdBranchData  =  { 'branchId': candidateData.rdbranch };
    candidateData.rdbranch = rdBranchData;
    console.log('Hiii ' + JSON.stringify(candidateData));
    if (candidateData.active === 'false') {
        candidateData.active = false;
    } else {
        candidateData.active = true;
    }
    this.candidateService.createCandidate(candidateData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('Candidate (' + candidateData + ') has been added Successfully...!!');
        this.candidateAdded.emit({ candidate: candidateData });
        this.closeModal();
      }
    });
  }

  updateCandidate() {
    console.log('Update candidate called ');
    console.log(JSON.stringify(this.candidate));

    const candidateData = JSON.parse(JSON.stringify(this.candidate));
    candidateData.updatedBy = {'userId': this.candidate.updatedBy.userId};
    candidateData.createdBy = {'userId': this.candidate.createdBy.userId};
    candidateData.createdOn = this.candidate.createdOn;
    candidateData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    const rdBranchData  =  { 'branchId': this.candidate.rdbranch };
    candidateData.rdbranch = rdBranchData;
    console.log('Hiii ' + JSON.stringify(candidateData));
    if (candidateData.active === 'false') {
        candidateData.active = false;
    } else {
        candidateData.active = true;
    }

    this.candidateService.updateCandidate(candidateData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('Candidate (' + candidateData + ') has been updated Successfully...!!');
        this.candidateUpdated.emit({ candidate: candidateData });
        this.closeModal();
      }
    });
  }

  private closeModal(): void {
    this.candidate = this.defaultCandidate;
      console.log(this.candidate.candidateId);
      this.closeBtn.nativeElement.click();
  }


}
