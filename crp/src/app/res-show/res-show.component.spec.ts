import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResShowComponent } from './res-show.component';

describe('ResShowComponent', () => {
  let component: ResShowComponent;
  let fixture: ComponentFixture<ResShowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ResShowComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ResShowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
