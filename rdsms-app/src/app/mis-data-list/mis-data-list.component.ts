import { Component, OnInit } from '@angular/core';
import { IMis } from '../mis';
import { MisDataService } from '../mis-data.service';

@Component({
  selector: 'app-mis-data-list',
  templateUrl: './mis-data-list.component.html',
  styleUrls: ['./mis-data-list.component.css']
})
export class MisDataListComponent implements OnInit {

  public mis: IMis[];
  selectedMIS: IMis;

  constructor(private misService: MisDataService) { }

  onEdit(misContent) {
    console.log('onEdit function of mis-data component called...!!!');
    console.log(JSON.stringify(misContent));
    this.selectedMIS = JSON.parse(JSON.stringify(misContent));
  }

  deleteMisContent(misId) {
    console.log('deleteMisContent called for MIS Id - ' + misId);
  }
  ngOnInit() {
    console.log('Getting data from mis-data service..');
    this.misService.getMisData().subscribe(data => this.mis = data);
  }

}
