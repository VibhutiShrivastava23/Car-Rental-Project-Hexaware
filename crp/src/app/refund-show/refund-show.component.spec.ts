import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RefundShowComponent } from './refund-show.component';

describe('RefundShowComponent', () => {
  let component: RefundShowComponent;
  let fixture: ComponentFixture<RefundShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [RefundShowComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(RefundShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
