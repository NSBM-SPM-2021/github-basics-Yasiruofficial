import {Component, Input, OnInit,OnDestroy} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {AuthService} from "../services/auth.service";
import {TokenStorageService} from "../services/token-storage.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnDestroy{

  loginBtnClicked: boolean = false;
  isError : boolean = false;
  errorText : string = "";

  constructor(private authService: AuthService,
              private tokenStorage: TokenStorageService,
              private router: Router,
              private route: ActivatedRoute
  ) { }

  login : Subscription = new Subscription();


  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  submit() : any {

    if(!this.form.valid) {
      this.isError = true;
      return false
    }

    this.loginBtnClicked  = true
    this.isError = false;
    this.errorText = "";

    const { username, password } = this.form.value;


      this.login = this.authService.login(username, password).subscribe(

        data => {
          this.tokenStorage.saveToken(data.access_token);
          if(this.route.snapshot.queryParams['returnUrl']){
            this.router.navigate([this.route.snapshot.queryParams['returnUrl']]);
          }else{
            this.router.navigate(['dashboard']);
          }
          this.loginBtnClicked  = false
        },
        err => {
          this.isError = true;
          if(err.status === 403){
            this.errorText = "Invalid Username/Password";
          }else{
            this.errorText = "Please check your connection";
          }
          this.loginBtnClicked  = false
        }
      );
  }

  ngOnDestroy() {
    this.login.unsubscribe();
  }

}
