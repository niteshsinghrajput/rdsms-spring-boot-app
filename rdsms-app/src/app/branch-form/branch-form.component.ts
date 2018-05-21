import { Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';
import { BranchService } from '../branch.service';
import { IBranch } from '../branch';
import { IDirector } from '../director';
import { DatePipe } from '@angular/common';
import { DirectorService } from '../director.service';


@Component({
  selector: 'app-branch-form',
  templateUrl: './branch-form.component.html',
  styleUrls: ['./branch-form.component.css'],
  providers: [BranchService, DirectorService, DatePipe]
})
export class BranchFormComponent implements OnInit {

  public title_add = 'Add New Branch';
  public title_update = 'Update Branch Detail';
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input()
  branch: IBranch;

  @Output()
  branchUpdated = new EventEmitter();

  @Output()
  branchAdded = new EventEmitter();

  public directors: IDirector[];
  public selectedDirector: IDirector;

  constructor(private branchService: BranchService, private directorService: DirectorService, public datepipe: DatePipe) { }

  // add branch
  addBranch() {
    console.log('addBranch in branch-form component..');
    console.log(JSON.stringify(this.branch));
    const branchData = JSON.parse(JSON.stringify(this.branch));
    branchData.updatedBy = {'userId': 3};
    branchData.createdBy = {'userId': 3};
    branchData.createdOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    branchData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    const director  =  { 'directorId': branchData.director };
    branchData.director = director;
    console.log('Hiii ' + JSON.stringify(branchData));
    if (branchData.active === 'false') {
      branchData.active = false;
    } else {
      branchData.active = true;
    }

    this.branchService.createBranch(branchData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('Branch (' + branchData + ') has been added Successfully...!!');
        this.branchAdded.emit({ branch: branchData });
        this.closeModal();
      }
    });

  }

  updateBranch() {
    console.log('updateBranch called...!!!' + JSON.stringify(this.branch));
    const branchData = JSON.parse(JSON.stringify(this.branch));
    const director  =  { 'directorId': branchData.director };
    branchData.director = director;
    if (branchData.active === 'true') {
      branchData.active = true;
    } else {
      branchData.active = false;
    }
    const updatedBranchData = {
        'branchId': branchData.branchId,
        'branchName': branchData.branchName,
        'address': branchData.address,
        'city': branchData.city,
        'district': branchData.district,
        'createdOn': branchData.createdOn,
        'updatedOn': branchData.updatedOn,
        'director': {
            'directorId': branchData.director.directorId
        },
        'updatedBy': {
                'userId': branchData.updatedBy.userId
        },
        'createdBy': {
            'userId': branchData.createdBy.userId
        },
        'active': branchData.active
    };

    console.log('Before sending data to update in db...');
    console.log(updatedBranchData);

    this.branchService.updateBranch(updatedBranchData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('Branch with ID = ' + updatedBranchData.branchId + ' has been updated Successfully..!!');
        console.log(updatedBranchData);
        this.branchUpdated.emit({ branch: branchData });
        this.closeModal();
      }
    });
  }

  ngOnInit() {
    this.branch = {
      'branchId': 0,
      'branchName': 'Enter Branch Name',
      'address': 'Enter Address',
      'city': 'Enter City',
      'district': 'Enter District',
      'createdOn': new Date(),
      'createdBy': {'userId': 0},
      'updatedBy': {'userId': 0},
      'updatedOn': new Date(),
      'director': {'directorId': 0},
      'active': false
    };

    this.directorService.getDirectors().subscribe(data => this.directors = data);
  }

  private closeModal(): void {
    this.closeBtn.nativeElement.click();
    this.branch = {
      'branchId': 0,
      'branchName': 'Enter Branch Name',
      'address': 'Enter Address',
      'city': 'Enter City',
      'district': 'Enter District',
      'createdOn': new Date(),
      'createdBy': {'userId': 0},
      'updatedBy': {'userId': 0},
      'updatedOn': new Date(),
      'director': {'directorId': 0},
      'active': false
    };
}

}
