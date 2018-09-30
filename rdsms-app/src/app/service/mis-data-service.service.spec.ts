import { TestBed, inject } from '@angular/core/testing';

import { MisDataService } from './mis-data.service';

describe('MisDataServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [MisDataService]
    });
  });

  it('should be created', inject([MisDataService], (service: MisDataService) => {
    expect(service).toBeTruthy();
  }));
});
