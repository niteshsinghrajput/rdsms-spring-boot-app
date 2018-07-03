import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OperatortypeComponent } from './operatortype.component';

describe('OperatortypeComponent', () => {
  let component: OperatortypeComponent;
  let fixture: ComponentFixture<OperatortypeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OperatortypeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OperatortypeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
