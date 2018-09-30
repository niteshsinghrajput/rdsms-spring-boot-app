import { TestBed, inject } from '@angular/core/testing';

import { DsrService } from './dsr.service';

describe('DsrService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [DsrService]
    });
  });

  it('should be created', inject([DsrService], (service: DsrService) => {
    expect(service).toBeTruthy();
  }));
});
