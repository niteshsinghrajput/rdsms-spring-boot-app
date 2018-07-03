import { Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef} from '@angular/core';
import { IDirector } from '../director';
import { DirectorService } from '../director.service';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-director-form',
  templateUrl: './director-form.component.html',
  styleUrls: ['./director-form.component.css'],
  providers: [DirectorService, DatePipe]
})
export class DirectorFormComponent implements OnInit {

  public title_add = 'Add New Director';
  public title_update = 'Update Director Detail';
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input()
  director: IDirector;

  @Output()
  directorUpdated = new EventEmitter();

  @Output()
  directorAdded = new EventEmitter();

  defaultDirector: IDirector = {
    'directorId': 0, 'directorName': 'Enter Director Name', 'photoId': 0, 'fatherName': 'Enter Father Name',
    'dob': new Date(), 'primaryMobile': 'Enter Primary Mobile',  'alternateMobile': 'Enter Alternate Mobile',
    'bankName': 'Enter Bank Name',  'branchName': 'Enter Branch Name', 'ifscCode': 'Enter IFSC Code',
    'accountNumber': 'Enter Account Number',  'createdOn': new Date(),  'updatedOn': new Date(),
    'createdBy': { 'userId': 0 }, 'updatedBy': { 'userId': 0 },
    'active': true
};

  constructor(private directorService: DirectorService, public datepipe: DatePipe) { }

  addDirector() {
    console.log('Add Director called ');
    console.log(JSON.stringify(this.director));
    const directorData = JSON.parse(JSON.stringify(this.director));
    directorData.updatedBy = {'userId': 3};
    directorData.createdBy = {'userId': 3};
    directorData.createdOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    directorData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    this.directorService.createDirector(directorData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('Director (' + directorData + ') has been added Successfully...!!');
        this.directorAdded.emit({ director: directorData });
        this.closeModal();
      }
    });
  }

  updateDirector() {
    console.log('updateDirector called ');
    console.log(JSON.stringify(this.director));

    const directorData = JSON.parse(JSON.stringify(this.director));
    directorData.updatedBy = {'userId': this.director.updatedBy.userId};
    directorData.createdBy = {'userId': this.director.createdBy.userId};
    directorData.createdOn = this.director.createdOn;
    directorData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    console.log('Hiii ' + JSON.stringify(directorData));
    if (directorData.active === 'false') {
      directorData.active = false;
    } else {
      directorData.active = true;
    }

    this.directorService.updateDirector(directorData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('Director (' + directorData + ') has been updated Successfully...!!');
        this.directorUpdated.emit({ director: directorData });
        this.closeModal();
      }
    });
  }

  ngOnInit() {
    this.director = this.defaultDirector;
  }

  private closeModal(): void {
    this.director = this.defaultDirector;
      console.log(this.director.directorId);
      this.closeBtn.nativeElement.click();
  }

}
