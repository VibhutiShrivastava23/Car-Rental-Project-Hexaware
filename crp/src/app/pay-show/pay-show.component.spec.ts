import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PayShowComponent } from './pay-show.component';

describe('PayShowComponent', () => {
  let component: PayShowComponent;
  let fixture: ComponentFixture<PayShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [PayShowComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PayShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
