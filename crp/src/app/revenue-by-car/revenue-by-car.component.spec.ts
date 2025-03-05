import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RevenueByCarComponent } from './revenue-by-car.component';

describe('RevenueByCarComponent', () => {
  let component: RevenueByCarComponent;
  let fixture: ComponentFixture<RevenueByCarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RevenueByCarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RevenueByCarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
