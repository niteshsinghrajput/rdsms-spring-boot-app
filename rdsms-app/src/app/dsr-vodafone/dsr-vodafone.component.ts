import { Component, OnInit } from '@angular/core';
import { DsrService } from '../dsr.service';
import { IDsrVodafone } from '../dsr-vodafone';

@Component({
  selector: 'app-dsr-vodafone',
  templateUrl: './dsr-vodafone.component.html',
  styleUrls: ['./dsr-vodafone.component.css'],
  providers: [DsrService]
})
export class DsrVodafoneComponent implements OnInit {

  constructor(private dsrService: DsrService) { }
  dsrVodafones: IDsrVodafone[];

  ngOnInit() {
    console.log('Getting dsr-vodafone data from dsr-service...');
    this.dsrService.getVodafoneDsrData().subscribe(data => this.dsrVodafones = data);
  }

}
