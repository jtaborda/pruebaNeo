import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreateUpdateClienteComponent } from './create-update-cliente.component';

describe('CreateUpdateClienteComponent', () => {
  let component: CreateUpdateClienteComponent;
  let fixture: ComponentFixture<CreateUpdateClienteComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CreateUpdateClienteComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CreateUpdateClienteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
