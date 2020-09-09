import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreatepersonFormComponent } from './createperson-form.component';

describe('CreatepersonFormComponent', () => {
  let component: CreatepersonFormComponent;
  let fixture: ComponentFixture<CreatepersonFormComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreatepersonFormComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CreatepersonFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
