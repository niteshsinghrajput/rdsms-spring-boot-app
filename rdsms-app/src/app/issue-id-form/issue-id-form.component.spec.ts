import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { IssueIdFormComponent } from './issue-id-form.component';

describe('IssueIdFormComponent', () => {
  let component: IssueIdFormComponent;
  let fixture: ComponentFixture<IssueIdFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ IssueIdFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(IssueIdFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
