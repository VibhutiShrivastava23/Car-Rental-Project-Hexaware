import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RevenueByDateComponent } from './revenue-by-date.component';

describe('RevenueByDateComponent', () => {
  let component: RevenueByDateComponent;
  let fixture: ComponentFixture<RevenueByDateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RevenueByDateComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RevenueByDateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
