import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  menus : any = [
    {
      heading: "MENU1",
      options:
        [
          {name: "IAM",link: "iam", order: 1},
          {name: "Employee",link: "employee", order: 2},
        ]
    }
  ];

  constructor() { }

  ngOnInit(): void {
    console.log("ProfileComponent ngOnInit")
  }

}
