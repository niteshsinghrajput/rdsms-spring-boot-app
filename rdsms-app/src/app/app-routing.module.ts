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
import { LoginComponent } from './login/login.component';
import { UrlPermission } from './url.permission';
import { RoleGuardService } from './role-guard.service';

const routes: Routes = [

    {path: 'roles', component: RolesComponent, canActivate: [RoleGuardService], data: { expectedRole : 'ROLE_ADMIN'} },
    {path: 'users', component: UserListComponent, canActivate: [RoleGuardService], data: { expectedRole : 'ROLE_ADMIN'}  },
    {path: 'branches', component: BranchListComponent, canActivate: [UrlPermission]},
    {path: 'candidates', component: CandidateListComponent, canActivate: [UrlPermission]},
    {path: 'directors', component: DirectorListComponent, canActivate: [UrlPermission]},
    {path: 'mis', component: MisDataListComponent, canActivate: [UrlPermission]},
    {path: 'ids', component: IdListComponent, canActivate: [UrlPermission]},
    {path: 'issue-ids', component: IssueIdListComponent, canActivate: [UrlPermission]},
    {path: 'dsrBsnl', component: DsrBsnlComponent, canActivate: [UrlPermission]},
    {path: 'dsrVodafone', component: DsrVodafoneComponent, canActivate: [UrlPermission]},
    {path: 'operator', component: OperatorComponent, canActivate: [UrlPermission]},
    {path: 'operatortypes', component: OperatortypeComponent, canActivate: [UrlPermission]},
    {path: 'login', component: LoginComponent },
    {path: '', redirectTo: '/candidates', pathMatch: 'full' },
    {path: '**', redirectTo: '/login' }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule { }
export const routingComponents = [RolesComponent, UserListComponent,
    BranchListComponent, CandidateListComponent, DirectorListComponent,
     MisDataListComponent, DsrBsnlComponent, DsrVodafoneComponent, IssueIdListComponent];
