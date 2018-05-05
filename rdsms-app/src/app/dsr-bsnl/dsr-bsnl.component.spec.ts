import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DsrBsnlComponent } from './dsr-bsnl.component';

describe('DsrBsnlComponent', () => {
  let component: DsrBsnlComponent;
  let fixture: ComponentFixture<DsrBsnlComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DsrBsnlComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DsrBsnlComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
