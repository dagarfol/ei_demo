import { TestBed } from '@angular/core/testing';

import { CaredebtService } from './caredebt.service';

describe('CaredebtService', () => {
  let service: CaredebtService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CaredebtService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
