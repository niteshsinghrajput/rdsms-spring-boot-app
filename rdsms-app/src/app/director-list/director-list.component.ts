import { Component, OnInit } from '@angular/core';
import { IDirector } from '../models/director';
import { DirectorService } from '../service/director.service';

@Component({
  selector: 'app-director-list',
  templateUrl: './director-list.component.html',
  styleUrls: ['./director-list.component.css'],
  providers: [DirectorService]
})
export class DirectorListComponent implements OnInit {

  directors: IDirector[];
  selectedDirector: IDirector | any;
  public message: string;
  public displayMessage = false;

  constructor(private directorService: DirectorService) { }

  onAddNew() {
    this.selectedDirector = {
      'directorId': 0
      /* 'directorId': 0, 'directorName': 'Enter Director Name', 'photoId': 0, 'fatherName': 'Enter Father Name',
      'dob': new Date(), 'primaryMobile': 'Enter Primary Mobile',  'alternateMobile': 'Enter Alternate Mobile',
      'bankName': 'Enter Bank Name',  'branchName': 'Enter Branch Name', 'ifscCode': 'Enter IFSC Code',
      'accountNumber': 'Enter Account Number',  'createdOn': new Date(),  'updatedOn': new Date(),
      'createdBy': { 'userId': 0 }, 'updatedBy': { 'userId': 0 },
      'active': true */
  };
  }

  deleteDirector(directorId) {
    console.log('deleteCandidate called for Candidate Id - ' + directorId);
    this.directorService.deleteDirector(directorId)
    .subscribe(successCode => {
      if (successCode === 200) {
        const msg = 'Director [DirectorId=' + directorId + '] has been deleted successfully..!!!';
        console.log(msg);
        this.displayAlert(msg);
        this.getDirectors();
      }
    });
  }

  onDirectorEdit(director) {
    console.log('onDirectorEdit function called...!!!');
    console.log(director);
    this.selectedDirector = JSON.parse(JSON.stringify(director));
  }

  saveDirectorToList(event) {
    console.log('Director [ name = ' + event.director.directorName + '] has been added successfully..!!');
    this.getDirectors();
    this.displayAlert('Director has been added successfully..!!');
  }

  updateDirectorList(event) {
    console.log('Director [ name = ' + event.director.directorName + '] has been updated successfully..!!');
    this.getDirectors();
    this.displayAlert('Director has been updated successfully..!!');
  }

  getDirectors() {
    this.directorService.getDirectors().subscribe(data => this.directors = data);
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

  ngOnInit() {
    console.log('Getting list of directors from director service...');
    this.getDirectors();
  }


}
