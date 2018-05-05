import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DsrVodafoneComponent } from './dsr-vodafone.component';

describe('DsrVodafoneComponent', () => {
  let component: DsrVodafoneComponent;
  let fixture: ComponentFixture<DsrVodafoneComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DsrVodafoneComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DsrVodafoneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
