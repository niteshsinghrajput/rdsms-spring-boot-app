import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RolesComponent } from './roles/roles.component';
import { UserListComponent } from './user-list/user-list.component';
import { BranchListComponent } from './branch-list/branch-list.component';
import { CandidateListComponent } from './candidate-list/candidate-list.component';
import { DirectorListComponent } from './director-list/director-list.component';
import { MisDataListComponent } from './mis-data-list/mis-data-list.component';
import { DsrBsnlComponent } from './dsr-bsnl/dsr-bsnl.component';
import { DsrVodafoneComponent } from './dsr-vodafone/dsr-vodafone.component';
import { OperatorComponent } from './operator/operator.component';
import { OperatortypeComponent } from './operatortype/operatortype.component';
import { IdListComponent } from './id-list/id-list.component';
import { IssueIdListComponent } from './issue-id-list/issue-id-list.component';

const routes: Routes = [
    {path: '', redirectTo: 'users' , pathMatch: 'full'},
    {path: 'roles', component: RolesComponent},
    {path: 'users', component: UserListComponent },
    {path: 'branches', component: BranchListComponent},
    {path: 'candidates', component: CandidateListComponent},
    {path: 'directors', component: DirectorListComponent},
    {path: 'mis', component: MisDataListComponent},
    {path: 'ids', component: IdListComponent},
    {path: 'issue-ids', component: IssueIdListComponent},
    {path: 'dsrBsnl', component: DsrBsnlComponent},
    {path: 'dsrVodafone', component: DsrVodafoneComponent},
    {path: 'operator', component: OperatorComponent},
    {path: 'operatortypes', component: OperatortypeComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
export const routingComponents = [RolesComponent, UserListComponent,
    BranchListComponent, CandidateListComponent, DirectorListComponent,
     MisDataListComponent, DsrBsnlComponent, DsrVodafoneComponent, IssueIdListComponent];
