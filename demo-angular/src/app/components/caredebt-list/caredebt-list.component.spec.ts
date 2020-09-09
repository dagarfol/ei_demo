import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CaredebtListComponent } from './caredebt-list.component';

describe('CaredebtListComponent', () => {
  let component: CaredebtListComponent;
  let fixture: ComponentFixture<CaredebtListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CaredebtListComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CaredebtListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
