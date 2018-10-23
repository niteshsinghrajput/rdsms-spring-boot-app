import { Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';
import { OperatorService } from '../service/operator.service';
import { IOperator } from '../models/operator';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-operator-form',
  templateUrl: './operator-form.component.html',
  styleUrls: ['./operator-form.component.css'],
  providers: [OperatorService, DatePipe]
})
export class OperatorFormComponent implements OnInit {

  public title_add = 'Add New Operator';
  public title_update = 'Update Operator Detail';
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input()
  operator: IOperator;

  @Output()
  operatorUpdated = new EventEmitter();

  @Output()
  operatorAdded = new EventEmitter();

  defaultOperator: IOperator = {
    'operatorId': 0,
    'operatorName' : 'Enter Operator Name',
    'description': 'Enter Operator Description',
    'createdBy' : { 'userId': 1},
    'updatedBy': { 'userId': 1},
    'createdOn': new Date(),
    'updatedOn': new Date(),
    'active': true
  };

  constructor(private service: OperatorService, public datepipe: DatePipe) { }

  ngOnInit() {
    this.operator = this.defaultOperator;
  }

  addOperator() {
    console.log('AddOperator called..');
    console.log(JSON.stringify(this.operator));

    const operatorData = JSON.parse(JSON.stringify(this.operator));
    operatorData.updatedBy = {'userId': 3};
    operatorData.createdBy = {'userId': 3};
    operatorData.createdOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    operatorData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    this.service.createOperator(operatorData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('Operator (' + operatorData + ') has been added Successfully...!!');
        this.operatorAdded.emit({ operator: operatorData });
        this.closeModal();
      }
    });
  }

  updateOperator() {
    console.log('updateOperator called ');
    console.log(JSON.stringify(this.operator));

    const operatorData = JSON.parse(JSON.stringify(this.operator));
    operatorData.updatedBy = {'userId': this.operator.updatedBy.userId};
    operatorData.createdBy = {'userId': this.operator.createdBy.userId};
    operatorData.createdOn = this.operator.createdOn;
    operatorData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    console.log('Hiii ' + JSON.stringify(operatorData));
    if (operatorData.active === 'false') {
      operatorData.active = false;
    } else {
      operatorData.active = true;
    }

    this.service.updateOperator(operatorData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('Operator (' + operatorData + ') has been updated Successfully...!!');
        this.operatorUpdated.emit({ operator: operatorData });
        this.closeModal();
      }
    });
  }

  private closeModal(): void {
    this.operator = this.defaultOperator;
    this.closeBtn.nativeElement.click();
  }

}
