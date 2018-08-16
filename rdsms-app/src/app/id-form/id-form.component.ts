import { Component, OnInit, Input, Output, ViewChild, ElementRef, EventEmitter } from '@angular/core';
import { DatePipe } from '@angular/common';
import { ID } from '../id';
import { IOperator } from '../operator';
import { IBranch } from '../branch';
import { OperatorService } from '../operator.service';
import { BranchService } from '../branch.service';
import { IdService } from '../id.service';


@Component({
  selector: 'app-id-form',
  templateUrl: './id-form.component.html',
  styleUrls: ['./id-form.component.css'],
  providers: [IdService, OperatorService, BranchService, DatePipe]
})
export class IdFormComponent implements OnInit {

  public title_add = 'Add New ID';
  public title_update = 'Update ID Detail';
  @ViewChild('closeBtn') closeBtn: ElementRef;

  @Input()
  id: ID;

  @Output()
  idUpdated = new EventEmitter();

  @Output()
  idAdded = new EventEmitter();

  public operators: IOperator[];
  public selectedOperator: IOperator;
  public branches: IBranch[];
  public selectedBranch: IBranch;


  constructor(private service: IdService, private operatorService: OperatorService,
    private branchService: BranchService, public datepipe: DatePipe) { }

  defaultId = {
    'id': 0,
    'idNumber': 'Enter ID Number',
    'mobile': 'Enter Mobile Number',
    'operator': 'Select Operator',
    'rdbranch': 'Select Branch',
    'createdBy': { 'userId': 0 },
    'updatedBy': { 'userId': 0 },
    'createdOn': new Date(),
    'updatedOn': new Date(),
    'active': false

  };

  ngOnInit() {
    this.id = this.defaultId;
    this.operatorService.getOperators().subscribe(data => this.operators = data);
    this.branchService.getBranches().subscribe(data => this.branches = data);
  }

  addID() {
    console.log('addID called..');
    console.log(JSON.stringify(this.id));

    const idData = JSON.parse(JSON.stringify(this.id));
    idData.updatedBy = {'userId': 3};
    idData.createdBy = {'userId': 3};
    idData.createdOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    idData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    const rdBranchData  =  { 'branchId': idData.rdbranch };
    idData.rdbranch = rdBranchData;
    const operatorData = { 'operatorId': idData.operator};
    idData.operator = operatorData;
    console.log('Hiii ' + JSON.stringify(idData));
    if (idData.active === 'false') {
      idData.active = false;
    } else {
      idData.active = true;
    }

    console.log(idData.operator);

    this.service.createID(idData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('ID (' + idData + ') has been added Successfully...!!');
        this.idAdded.emit({ id: idData });
        this.closeModal();
      }
    });
  }

  updateID() {
    console.log('Update ID called ');
    console.log(JSON.stringify(this.id));

    const idData = JSON.parse(JSON.stringify(this.id));
    idData.updatedBy = {'userId': this.id.updatedBy.userId};
    idData.createdBy = {'userId': this.id.createdBy.userId};
    idData.createdOn = this.id.createdOn;
    idData.updatedOn = this.datepipe.transform(new Date(), 'yyyy-MM-dd');
    const rdBranchData  =  { 'branchId': this.id.rdbranch };
    idData.rdbranch = rdBranchData;
    const operatorData = { 'operatorId': idData.operator};
    idData.operator = operatorData;
    console.log('Hiii ' + JSON.stringify(idData));
    if (idData.active === 'false') {
      idData.active = false;
    } else {
      idData.active = true;
    }

    this.service.updateID(idData)
    .subscribe(successCode => {
      if (successCode === 200) {
        console.log('ID (' + idData + ') has been updated Successfully...!!');
        this.idUpdated.emit({ id: idData });
        this.closeModal();
      }
    });
  }

  private closeModal(): void {
    this.closeBtn.nativeElement.click();
    this.id = this.defaultId;
  }

}
