import { TestBed, inject } from '@angular/core/testing';

import { OperatortypeService } from './operatortype.service';

describe('OperatortypeService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [OperatortypeService]
    });
  });

  it('should be created', inject([OperatortypeService], (service: OperatortypeService) => {
    expect(service).toBeTruthy();
  }));
});
