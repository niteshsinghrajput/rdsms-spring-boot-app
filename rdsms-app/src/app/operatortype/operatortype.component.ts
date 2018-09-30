import { Component, OnInit } from '@angular/core';
import { OperatortypeService } from '../service/operatortype.service';
import { IOperatorType } from '../models/operatortype';

/**
 * @author Nitesh
 */

@Component({
  selector: 'app-operatortype',
  templateUrl: './operatortype.component.html',
  styleUrls: ['./operatortype.component.css'],
  providers: [OperatortypeService]
})
export class OperatortypeComponent implements OnInit {

  operatorTypes: IOperatorType[];
  selectedOperatorType: IOperatorType | any;
  public message: string;
  public displayMessage = false;

  constructor(private service: OperatortypeService) { }

  ngOnInit() {
    this.getOperatorTypes();
  }

  onAddNew() {
    console.log('onAddNew called..');
    this.selectedOperatorType = {
      'operatorTypeId': 0
      /* ,
      'operatorType' : 'Enter Operator Type',
      'operator': {
        'operatorId': 0
      },
      'active': true */
    };
    console.log(this.selectedOperatorType.operatorTypeId);
  }

  onOperatorTypeEdit(operatorType) {
    console.log('onOperatorTypeEdit function called...!!!');
    console.log(operatorType);
    this.selectedOperatorType = JSON.parse(JSON.stringify(operatorType));
  }

  getOperatorTypes() {
    console.log('Getting operator types from backend..');
    this.service.getOperatorTypeList().subscribe(data => this.operatorTypes = data);
  }

  saveOperatorTypeToList(event) {
    console.log('New OperatorType Added to OperatorType List..' + event.operator.operatorName);
    this.getOperatorTypes();
    this.displayAlert('Operator has been added successfully..!!');
  }

  updateOperatorTypeList(event) {
    console.log('OperatorType has been updated successfully..' + event.operatorType.operatorType);
    this.getOperatorTypes();
    this.displayAlert('OperatorType has been updated successfully..!!');
  }

  deleteOperatorType(operatorTypeId) {
    console.log('deleteOperatorType called for Operator Id - ' + operatorTypeId);
    this.service.deleteOperatorType(operatorTypeId)
    .subscribe(successCode => {
      if (successCode === 200) {
        const msg = 'OperatorType [OperatorTypeId=' + operatorTypeId + '] has been deleted successfully..!!!';
        console.log(msg);
        this.displayAlert(msg);
        this.getOperatorTypes();
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
