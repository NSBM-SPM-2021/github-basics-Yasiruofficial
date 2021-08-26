import { Component, OnInit } from '@angular/core';
import {TokenStorageService} from "../../services/token-storage.service";

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private tokenStorage: TokenStorageService) { }

  roles : any;

  ngOnInit(): void {
    this.roles = this.tokenStorage.getRoles();
  }

}
