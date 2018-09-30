import { Component, OnInit, Input, Output, EventEmitter, ViewChild, ElementRef } from '@angular/core';
import { IOperatorType } from '../models/operatortype';
import { OperatortypeService } from '../service/operatortype.service';
import { OperatorService } from '../service/operator.service';
import { IOperator } from '../models/operator';

@Component({
  selector: 'app-operatortype-form',
  templateUrl: './operatortype-form.component.html',
  styleUrls: ['./operatortype-form.component.css'],
  providers: [OperatortypeService, OperatorService]
})
export class OperatortypeFormComponent implements OnInit {

  public title_add = 'Add New OperatorType';
  public title_update = 'Update OperatorType Detail';
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input()
  operatorType: IOperatorType;

  @Output()
  operatorTypeUpdated = new EventEmitter();

  @Output()
  operatorTypeAdded = new EventEmitter();

  public operators: IOperator[];
  public selectedOperator: IOperator;

  defaultOperatorType: IOperatorType = {
      'operatorTypeId': 0,
      'operatorType' : 'Enter Operator Type',
      'operator': {
        'operatorId': 0
      },
      'active': true
  };

  constructor(private service: OperatortypeService, private operatorService: OperatorService) { }

  ngOnInit() {
    this.operatorType = this.defaultOperatorType;
    this.operatorService.getOperators().subscribe(data => this.operators = data);
  }

  addOperatorType() {
    console.log('AddOperatorType called..', this.selectedOperator);
    console.log(JSON.stringify(this.operatorType));

    const operatorTypeData = JSON.parse(JSON.stringify(this.operatorType));
    operatorTypeData.operator = {'operatorId': this.operatorType.operator};
    console.log('Hiii ', operatorTypeData);
    this.service.createOperatorType(operatorTypeData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('OperatorType (' + operatorTypeData + ') has been added Successfully...!!');
        this.operatorTypeAdded.emit({ operator: operatorTypeData });
        this.closeModal();
      }
    });
  }

  updateOperatorType() {
    console.log('updateOperatorType called ');
    console.log(JSON.stringify(this.operatorType));

    const operatorTypeData = JSON.parse(JSON.stringify(this.operatorType));
    const operatorData = {'operatorId': this.operatorType.operator};
    operatorTypeData.operator = operatorData;

    if (operatorTypeData.active === 'false') {
      operatorTypeData.active = false;
    } else {
      operatorTypeData.active = true;
    }

    this.service.updateOperatorType(operatorTypeData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('OperatorType (' + operatorTypeData + ') has been updated Successfully...!!');
        this.operatorTypeUpdated.emit({ operatorType: operatorTypeData });
        this.closeModal();
      }
    });
  }

  private closeModal(): void {
    this.operatorType = this.defaultOperatorType;
    this.closeBtn.nativeElement.click();
  }

}
