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
export class LoginComponent implements OnInit {

  private isLoggedIn: boolean = false;
  private roles: any;
  private isLoginFailed: boolean = false;
  private errorMessage: any;


  constructor(private authService: AuthService,
              private tokenStorage: TokenStorageService,
              private router: Router,
              private route: ActivatedRoute
  ) { }

  login : Subscription = new Subscription();

  ngOnInit(): void {}

  form: FormGroup = new FormGroup({
    username: new FormControl(''),
    password: new FormControl(''),
  });

  submit() {

    const { username, password } = this.form.value;

    this.login = this.authService.login(username, password).subscribe(

      data => {
        this.tokenStorage.saveToken(data.access_token);
        if(this.route.snapshot.queryParams['returnUrl']){
          this.router.navigate([this.route.snapshot.queryParams['returnUrl']]);
        }else{
          this.router.navigate([this.route.snapshot.queryParams['dashboard']]);
        }

      },
      err => {
        console.log(JSON.stringify(err));
      }
    );

  }

  ngOnDestroy() {
    this.login.unsubscribe();
  }

  @Input() error: boolean = false

}
