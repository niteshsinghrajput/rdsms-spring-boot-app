import { Component, OnInit } from '@angular/core';
import { CandidateService } from '../candidate.service';
import { ICandidate } from '../candidate';

@Component({
  selector: 'app-candidate-list',
  templateUrl: './candidate-list.component.html',
  styleUrls: ['./candidate-list.component.css'],
  providers: [CandidateService]
})
export class CandidateListComponent implements OnInit {

  public candidates = [];
  public selectedCandidate: ICandidate;
  public message: string;
  public displayMessage = false;
  constructor(private candidateService: CandidateService) { }

  onCandidateEdit(candidate) {
    console.log('onCandidateEdit function called...!!!');
    console.log(candidate);
    this.selectedCandidate = JSON.parse(JSON.stringify(candidate));
  }

  saveCandidateToList(event) {
    console.log('Candidate ' + event.candidate.name + ' has been added successfully..!!');
    this.getCandidates();
    this.displayAlert('Candidate has been added successfully..!!');
  }

  updateCandidateList(event) {
    console.log('Candidate ' + event.candidate.name + 'has been updated successfully..!!');
    this.getCandidates();
    this.displayAlert('Candidate has been updated successfully..!!');
  }

  deleteCandidate(candidateId) {
    console.log('deleteCandidate called for Candidate Id - ' + candidateId);
    this.candidateService.deleteCandidate(candidateId)
    .subscribe(successCode => {
      if (successCode === 200) {
        const msg = 'Candidate [CandidateId=' + candidateId + '] has been deleted successfully..!!!';
        console.log(msg);
        this.displayAlert(msg);
        this.getCandidates();
      }
    });
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

  onAddNew() {
    console.log('onAddNew called..');
      this.selectedCandidate = {'candidateId': 0, 'name': 'Enter Name ', 'fatherName': 'Enter Father Name',
      'motherName': 'Enter Mother Name', 'dob': new Date(), 'address': 'Enter Address', 'landmark': 'Enter Landmark',
      'city': 'Enter City', 'district': 'Enter District', 'state': 'Enter State', 'postalCode': 'Enter Postal Code',
      'religion': 'Enter Religion', 'category': 'Enter Category', 'nationality': 'Enter Nationality',
      'knownLanguages': 'Enter Known Language', 'primaryMobile': 'Enter primary mobile',
      'alternateMobile': 'Enter alternate mobile', 'photoId': 0, 'bank': 'Enter Bank', 'branch': 'Enter Branch',
      'ifscCode': 'Enter IFSC', 'accountNumber': 'Enter Account', 'createdOn': new Date(),
      'updatedOn': new Date(), 'createdBy': {'userId': 0 }, 'updatedBy': { 'userId': 0 },
      'rdbranch': {'branchId': 0}, 'active': true
      };
      console.log(this.selectedCandidate);
  }

  ngOnInit() {
      console.log('Getting candidates from candidateService...');
      this.getCandidates();
  }

  getCandidates() {
    this.candidateService.getCandidates().subscribe(data => this.candidates = data);
  }

}
