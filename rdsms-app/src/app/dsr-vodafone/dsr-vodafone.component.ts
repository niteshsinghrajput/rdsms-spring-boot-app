import { Component, OnInit } from '@angular/core';
import { DsrService } from '../service/dsr.service';
import { IDsrVodafone } from '../models/dsr-vodafone';

@Component({
  selector: 'app-dsr-vodafone',
  templateUrl: './dsr-vodafone.component.html',
  styleUrls: ['./dsr-vodafone.component.css'],
  providers: [DsrService]
})
export class DsrVodafoneComponent implements OnInit {

  selectedFile: File = null;
  message: String = null;
  displayMessage = false;
  constructor(private dsrService: DsrService) { }
  dsrVodafones: IDsrVodafone[];

  ngOnInit() {
    console.log('Getting dsr-vodafone data from dsr-service...');
    this.getDSR();
  }

  showDetails(dsr) {
    console.log('ShowDetails called..' + JSON.stringify(dsr));
  }

  selectFile(event) {
    if (event.target.files.length > 0 ) {
      console.log(event.target.files[0]);
      this.selectedFile = event.target.files[0];
    }
  }

  getDSR() {
    this.dsrService.getVodafoneDsrData().subscribe(data => this.dsrVodafones = data);
  }

  uploadDsr() {
      console.log('UploadDsr called ... ' + this.selectedFile);
      this.dsrService.uploadVodaDsrData(this.selectedFile)
      .subscribe(successCode => {
        if (successCode === 200) {
          this.message = 'Vodafone DSR (' + this.selectedFile.name + ') has been uploaded Successfully...!!';
          console.log(this.message);
          this.displayAlert(this.message);
          this.getDSR();
        }
        if (successCode === 400) {
          this.message = 'Problem occured while upload Vodafone DSR ( ' + this.selectedFile.name + ')';
          this.displayAlert(this.message);
          this.getDSR();
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

}
