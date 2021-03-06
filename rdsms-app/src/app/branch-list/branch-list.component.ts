import { Component, OnInit } from '@angular/core';
import { BranchService } from '../service/branch.service';
import { IBranch } from '../models/branch';

@Component({
  selector: 'app-branch-list',
  templateUrl: './branch-list.component.html',
  styleUrls: ['./branch-list.component.css'],
  providers: [ BranchService]
})
export class BranchListComponent implements OnInit {

  public branches = [];
  public selectedBranch: IBranch;
  public message: string;
  public displayMessage = false;

  constructor(private branchService: BranchService) { }

  onEdit(branch) {
    console.log('onEdit function called...!!!');
    console.log(branch);
    this.selectedBranch = JSON.parse(JSON.stringify(branch));
  }

  saveBranchToList(event) {
    this.branches.push(event.branch);
    console.log('Branch has been added successfully..!!' + event.branch.branchName);
    this.displayAlert('Branch has been added successfully..!!');
  }

  updateBranchList(event) {
    console.log('updateBranchList called for Branch Id - ' + event.branch.branchId);
    this.branchService.updateBranch(event.branch);
    const msg = 'Branch [ Branch Id=' + event.branch.branchId + '] has been updated successfully..!!!';
    console.log(msg);
    this.displayAlert(msg);
    for ( let idx = 0; idx < this.branches.length; idx++) {
      const branch = this.branches[idx];
      if ( branch.branchId === event.branch.branchId) {
        this.branches[idx] = event.branch;
        break;
      }
    }
  }


  deleteBranch(branchId) {
    console.log('deleteBranch called for Branch Id - ' + branchId);
    this.branchService.deleteBranchById(branchId)
    .subscribe(successCode => {
      console.log('Hiii', successCode);
      if (successCode === 200) {
        const msg = 'Branch [BranchId=' + branchId + '] has been deleted successfully..!!!';
        console.log(msg);
        this.displayAlert(msg);
        for ( let idx = 0; idx < this.branches.length; idx++) {
          const branch = this.branches[idx];
          if (branch.branchId === branchId) {
              this.branches.splice(idx, 1);
              break;
          }
        }
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

  ngOnInit() {
      console.log('Getting all branches from database..!!!');
      this.branchService.getBranches().subscribe(data => this.branches = data);
  }

}
