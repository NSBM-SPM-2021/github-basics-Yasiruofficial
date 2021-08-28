import { Component, enableProdMode,OnInit } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import CustomStore from 'devextreme/data/custom_store'
import {Observable} from "rxjs";
import {EmployeeService} from "../../../services/employee.service";



@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent implements OnInit {

  dataSource: any = {};
  isVisitable : boolean = false;
  error:string = "";
  type:string = "";

  rolse = [
    { userRoleId : "1", name: "ADMIN"},
    { userRoleId: "2", name: "STAFF"},
  ];


  constructor(httpClient: HttpClient,private employeeService: EmployeeService) {

    this.dataSource = new CustomStore({

      key: "eno",
      load: (loadOptions:any) => employeeService.load(loadOptions),
      insert: (values) => employeeService.insert(values),
      update: (key, values) => employeeService.update(key,values),
      remove: (key) => employeeService.remove(key).then(),

    });

  }

  ngOnInit(): void {
  }

}
