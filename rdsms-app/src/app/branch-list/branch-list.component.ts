import { Component, OnInit } from '@angular/core';
import { BranchService } from '../branch.service';
import { IBranch } from '../branch';

@Component({
  selector: 'app-branch-list',
  templateUrl: './branch-list.component.html',
  styleUrls: ['./branch-list.component.css'],
  providers: [ BranchService]
})
export class BranchListComponent implements OnInit {

  public branches = [];
  constructor(private branchService: BranchService) { }

  ngOnInit() {
      console.log('Getting all branches from database..!!!');
      this.branchService.getBranches().subscribe(data => this.branches = data);
  }

}
