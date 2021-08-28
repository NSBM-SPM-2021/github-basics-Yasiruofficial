import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailGridComponent } from './detail-grid.component';

describe('DetailGridComponent', () => {
  let component: DetailGridComponent;
  let fixture: ComponentFixture<DetailGridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DetailGridComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DetailGridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
