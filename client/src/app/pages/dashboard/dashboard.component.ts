import {Component, OnInit, ViewChild} from '@angular/core';
import {TokenStorageService} from "../../services/token-storage.service";
import {DxDrawerComponent} from "devextreme-angular";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService,
              private router: Router) {}

  roles : any;

  ngOnInit(): void {
    this.roles = this.tokenStorage.getRoles();
  }

  logout(){
    this.tokenStorage.signOut();
    this.router.navigate(["/login"]);
  }

}
