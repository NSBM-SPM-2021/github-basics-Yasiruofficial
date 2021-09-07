import {ComponentFixture, ComponentFixtureAutoDetect, TestBed, waitForAsync} from '@angular/core/testing';

import { LoginComponent } from './login.component';
import { RouterTestingModule } from '@angular/router/testing';
import {CommonModule} from "@angular/common";
import {LoginRoutingModule} from "./login-routing.module";
import {MatCardModule} from "@angular/material/card";
import {ReactiveFormsModule} from "@angular/forms";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatProgressBarModule} from "@angular/material/progress-bar";
import {HttpClientModule} from "@angular/common/http";
import {authInterceptorProviders} from "../interceptors/auth.interceptor";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {DashboardComponent} from "../pages/dashboard/dashboard.component";

describe('LoginComponent', () => {
  let component: LoginComponent;
  let fixture: ComponentFixture<LoginComponent>;
  let loginBtn: any;

  const validUser = {
    username: 'HOHR2',
    password: '456'
  };

  const invalidUser = {
    username: 'K45345',
    password: '6153445'
  };

  const blankUser = {
    username: '',
    password: ''
  };

  const user = {
    validUsername: '',
    password: ''
  };


  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoginComponent ],
      imports: [
        CommonModule,
        LoginRoutingModule,
        MatCardModule,
        ReactiveFormsModule,
        MatInputModule,
        MatButtonModule,
        MatProgressBarModule,
        HttpClientModule,
        RouterTestingModule.withRoutes([{ path: 'dashboard', component: DashboardComponent }]),
        BrowserAnimationsModule
      ],
      providers: [
        authInterceptorProviders,
        { provide: ComponentFixtureAutoDetect,useValue: true },
      ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoginComponent);
    component = fixture.componentInstance;

  });

  function updateForm(userEmail:string, userPassword:string) {
    component.form.controls['username'].setValue(userEmail);
    component.form.controls['password'].setValue(userPassword);
  }

  it('Login fail when Username is blank', () => {
    updateForm(blankUser.username, validUser.password);

    loginBtn = fixture.debugElement.nativeElement.querySelector('#submit');
    loginBtn.click();

    expect(component.isError).toBeTruthy();

  });

  it('Login fail when Password is blank', () => {
    updateForm(validUser.username, blankUser.password);

    loginBtn = fixture.debugElement.nativeElement.querySelector('#submit');
    loginBtn.click();

    expect(component.isError).toBeTruthy();

  });

  it('Login fail and error text = "Invalid Username/Password" when Password is incorrect', waitForAsync (() => {
    updateForm(validUser.username, invalidUser.password);

    loginBtn = fixture.debugElement.nativeElement.querySelector('#submit');
    loginBtn.click();

    fixture.whenStable().then(() => {  // wait for async getQuote
      expect(component.isError).toBeTruthy();
      expect(component.errorText).toBe('Invalid Username/Password');
    });

  }));

  it('Login pass and error text = "" when Password is correct ', waitForAsync(() => {

    updateForm(validUser.username, validUser.password);

    loginBtn = fixture.debugElement.nativeElement.querySelector('#submit');
    loginBtn.click();

    fixture.whenStable().then(() => {  // wait for async getQuote
      expect(component.isError).toBeFalsy();
      expect(component.errorText).toBe('');
    });


  }));




});
