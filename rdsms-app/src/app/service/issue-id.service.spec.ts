import { TestBed, inject } from '@angular/core/testing';

import { IssueIdService } from './issue-id.service';

describe('IssueIdService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [IssueIdService]
    });
  });

  it('should be created', inject([IssueIdService], (service: IssueIdService) => {
    expect(service).toBeTruthy();
  }));
});
