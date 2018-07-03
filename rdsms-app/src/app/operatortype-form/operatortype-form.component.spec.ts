import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperatortypeFormComponent } from './operatortype-form.component';

describe('OperatortypeFormComponent', () => {
  let component: OperatortypeFormComponent;
  let fixture: ComponentFixture<OperatortypeFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperatortypeFormComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperatortypeFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
