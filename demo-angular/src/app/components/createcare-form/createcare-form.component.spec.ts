import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatecareFormComponent } from './createcare-form.component';

describe('CreatecareFormComponent', () => {
  let component: CreatecareFormComponent;
  let fixture: ComponentFixture<CreatecareFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatecareFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatecareFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
