import {Component, OnInit, ViewChild} from '@angular/core';
import {TokenStorageService} from "../../services/token-storage.service";
import {Router} from "@angular/router";


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {


  roles : any;

  constructor(private tokenStorage: TokenStorageService,
              private router: Router) {}


  ngOnInit(): void {
    this.roles = this.tokenStorage.getRoles();
  }

  logout(){
    this.tokenStorage.signOut();
    this.router.navigate(["/login"]);
  }

}
