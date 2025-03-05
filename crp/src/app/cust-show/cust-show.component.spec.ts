import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustShowComponent } from './cust-show.component';

describe('CustShowComponent', () => {
  let component: CustShowComponent;
  let fixture: ComponentFixture<CustShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [CustShowComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CustShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
