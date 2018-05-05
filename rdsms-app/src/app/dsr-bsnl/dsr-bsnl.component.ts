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

  constructor(private dsrService: DsrService) { }
  dsrBsnl: IDsrBsnl[];

  ngOnInit() {
      console.log('Getting list of directors from director service...');
      this.dsrService.getBsnlDsrData().subscribe(data => this.dsrBsnl = data);
  }

}
