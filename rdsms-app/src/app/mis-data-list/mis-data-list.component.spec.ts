import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MisDataListComponent } from './mis-data-list.component';

describe('MisDataListComponent', () => {
  let component: MisDataListComponent;
  let fixture: ComponentFixture<MisDataListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MisDataListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MisDataListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
