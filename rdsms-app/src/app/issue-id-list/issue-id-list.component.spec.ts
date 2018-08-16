import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IssueIdListComponent } from './issue-id-list.component';

describe('IssueIdListComponent', () => {
  let component: IssueIdListComponent;
  let fixture: ComponentFixture<IssueIdListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IssueIdListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IssueIdListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
