import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RevenueByUserComponent } from './revenue-by-user.component';

describe('RevenueByUserComponent', () => {
  let component: RevenueByUserComponent;
  let fixture: ComponentFixture<RevenueByUserComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RevenueByUserComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RevenueByUserComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
