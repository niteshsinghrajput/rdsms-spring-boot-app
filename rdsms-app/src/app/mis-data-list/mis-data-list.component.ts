import { Component, OnInit } from '@angular/core';
import { IMis } from '../models/mis';
import { MisDataService } from '../service/mis-data.service';
import { ExcelService } from '../service/excel.service';

@Component({
  selector: 'app-mis-data-list',
  templateUrl: './mis-data-list.component.html',
  styleUrls: ['./mis-data-list.component.css'],
  providers: [MisDataService, ExcelService]
})
export class MisDataListComponent implements OnInit {

  public mis: IMis[];
  selectedMIS: IMis;
  selectedFile: File = null;
  message: String = null;
  displayMessage = false;
  public currentRole = localStorage.getItem('currentRole');


  constructor(private misService: MisDataService, private service: ExcelService) { }

  showDetail(misContent) {
    console.log('showDetail function of mis-data component called...!!!');
    console.log(JSON.stringify(misContent));
    this.selectedMIS = JSON.parse(JSON.stringify(misContent));
  }

  selectFile(event) {
    if (event.target.files.length > 0 ) {
      console.log(event.target.files[0]);
      this.selectedFile = event.target.files[0];
    }
  }

  deleteMisContent(misId) {
    console.log('deleteMisContent called for MIS Id - ' + misId);
  }

  uploadDsr() {
    console.log('UploadDsr called ... ' + this.selectedFile);
    this.misService.uploadMISData(this.selectedFile)
    .subscribe(successCode => {
      if (successCode === 200) {
        this.message = 'MIS Data File (' + this.selectedFile.name + ') has been uploaded Successfully...!!';
        console.log(this.message);
        this.displayAlert(this.message);
        this.getMISData();
      }
      if (successCode === 400) {
        this.message = 'Problem occured while upload MIS Data File ( ' + this.selectedFile.name + ')';
        this.displayAlert(this.message);
        this.getMISData();
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

  getMISData() {
    this.misService.getMisData().subscribe(data => this.mis = data);
  }
  ngOnInit() {
    console.log('Getting data from mis-data service..');
    this.getMISData();
  }

   exportAsXLSX(): void {
    this.service.exportAsExcelFile(this.mis, 'mis');
 }


}
