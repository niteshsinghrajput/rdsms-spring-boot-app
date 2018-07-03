import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { HttpModule } from '@angular/http';
import { AppComponent } from './app.component';
import { RolesService } from './roles.service';
import { MenuService } from './menu.service';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { MenuComponent } from './menu/menu.component';
import { AppRoutingModule, routingComponents } from './app-routing.module';
import { UsersService } from './users.service';
import { BranchService } from './branch.service';
import { CandidateService } from './candidate.service';
import { MisDataService } from './mis-data.service';
import { RoleFormComponent } from './role-form/role-form.component';
import { FormsModule } from '@angular/forms';
import { UserFormComponent } from './user-form/user-form.component';
import { MisDataListComponent } from './mis-data-list/mis-data-list.component';
import { DirectorListComponent } from './director-list/director-list.component';
import { DsrBsnlComponent } from './dsr-bsnl/dsr-bsnl.component';
import { DsrVodafoneComponent } from './dsr-vodafone/dsr-vodafone.component';
import { DsrService } from './dsr.service';
import { BranchFormComponent } from './branch-form/branch-form.component';
import { DatePipe } from '@angular/common';
import { CandidateFormComponent } from './candidate-form/candidate-form.component';
import { DirectorFormComponent } from './director-form/director-form.component';
import { OperatorComponent } from './operator/operator.component';
import { OperatortypeComponent } from './operatortype/operatortype.component';
import { OperatorFormComponent } from './operator-form/operator-form.component';
import { OperatortypeFormComponent } from './operatortype-form/operatortype-form.component';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    MenuComponent,
    routingComponents,
    RoleFormComponent,
    UserFormComponent,
    MisDataListComponent,
    DirectorListComponent,
    DsrBsnlComponent,
    DsrVodafoneComponent,
    BranchFormComponent,
    CandidateFormComponent,
    DirectorFormComponent,
    OperatorComponent,
    OperatortypeComponent,
    OperatorFormComponent,
    OperatortypeFormComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    HttpModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [RolesService, MenuService, UsersService, BranchService,
    CandidateService, MisDataService, DsrService],
  bootstrap: [AppComponent]
})
export class AppModule { }
