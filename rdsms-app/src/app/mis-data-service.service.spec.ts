import { TestBed, inject } from '@angular/core/testing';

import { MisDataServiceService } from './mis-data-service.service';

describe('MisDataServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MisDataServiceService]
    });
  });

  it('should be created', inject([MisDataServiceService], (service: MisDataServiceService) => {
    expect(service).toBeTruthy();
  }));
});
