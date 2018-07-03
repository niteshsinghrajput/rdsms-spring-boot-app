import { Component, OnInit } from '@angular/core';
import { OperatorService } from '../operator.service';
import { IOperator } from '../operator';

@Component({
  selector: 'app-operator',
  templateUrl: './operator.component.html',
  styleUrls: ['./operator.component.css'],
  providers: [OperatorService]
})
export class OperatorComponent implements OnInit {

  operators: IOperator[];
  selectedOperator: IOperator;
  public message: string;
  public displayMessage = false;


  constructor(private operatorService: OperatorService) { }

  onOperatorEdit(operator) {
    console.log('onOperatorEdit function called...!!!');
    console.log(operator.operatorId);
    this.selectedOperator = JSON.parse(JSON.stringify(operator));
  }

  ngOnInit() {
    console.log('Getting list of operators from operator service...');
    this.getOperators();
  }

  getOperators() {
    this.operatorService.getOperators().subscribe(data => this.operators = data);
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

  onAddNew() {
    console.log('onAddNew called..');
    this.selectedOperator = {
      'operatorId': 0,
      'operatorName' : 'Enter Operator Name',
      'description': 'Enter Operator Description',
      'createdBy' : { 'userId': 1},
      'updatedBy': { 'userId': 1},
      'createdOn': new Date(),
      'updatedOn': new Date(),
      'active': true
    };
    console.log(this.selectedOperator.operatorId);
  }

  deleteOperator(operatorId) {
    console.log('deleteOperator called for Operator Id - ' + operatorId);
    this.operatorService.deleteOperator(operatorId)
    .subscribe(successCode => {
      if (successCode === 200) {
        const msg = 'Operator [OperatorId=' + operatorId + '] has been deleted successfully..!!!';
        console.log(msg);
        this.displayAlert(msg);
        this.getOperators();
      }
    });
  }

  saveOperatorToList(event) {
    console.log('New Operator Added to Operator List..' + event.operator.operatorName);
    this.getOperators();
    this.displayAlert('Operator has been added successfully..!!');
  }

  updateOperatorList(event) {
    console.log('Operator has been updated successfully..' + event.operator.operatorName);
    this.getOperators();
    this.displayAlert('Operator has been updated successfully..!!');
  }


}
