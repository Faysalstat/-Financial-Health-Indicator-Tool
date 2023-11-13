import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HealthVisualsComponent } from './health-visuals.component';

describe('HealthVisualsComponent', () => {
  let component: HealthVisualsComponent;
  let fixture: ComponentFixture<HealthVisualsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ HealthVisualsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(HealthVisualsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
