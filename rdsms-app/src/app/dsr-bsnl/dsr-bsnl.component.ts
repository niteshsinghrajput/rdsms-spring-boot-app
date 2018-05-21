import { Component, OnInit } from '@angular/core';
import {IDsrBsnl} from '../dsr-bsnl';
import {DsrService} from '../dsr.service';

@Component({
  selector: 'app-dsr-bsnl',
  templateUrl: './dsr-bsnl.component.html',
  styleUrls: ['./dsr-bsnl.component.css'],
  providers: [DsrService]
})
export class DsrBsnlComponent implements OnInit {

  selectedFile: File;
  constructor(private dsrService: DsrService) { }
  dsrBsnl: IDsrBsnl[];
  public message: string = null;
  public displayMessage = false;

  ngOnInit() {
      console.log('Getting list of directors from director service...');
      // this.dsrService.getBsnlDsrData().subscribe(data => this.dsrBsnl = data);
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
    this.dsrService.getBsnlDsrData().subscribe(data => this.dsrBsnl = data);
  }

  uploadDsr() {
      console.log('UploadDsr called ... ' + this.selectedFile);
      // this.dsrService.uploadBsnlDsrData(this.selectedFile).subscribe(data => this.dsrBsnl = data);
      this.dsrService.uploadBsnlDsrData(this.selectedFile)
      .subscribe(successCode => {
        if (successCode === 200) {
          this.message = 'BSNL DSR (' + this.selectedFile.name + ') has been uploaded Successfully...!!';
          console.log(this.message);
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
