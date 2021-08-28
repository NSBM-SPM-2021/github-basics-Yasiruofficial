import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { EmployeeRoutingModule } from './employee-routing.module';
import { EmployeeComponent } from './employee.component';
import {DxDataGridModule, DxLoadPanelModule, DxToastModule} from "devextreme-angular";
import {HttpClientModule} from "@angular/common/http";


@NgModule({
  declarations: [
    EmployeeComponent
  ],
  imports: [
    CommonModule,
    EmployeeRoutingModule,
    DxDataGridModule,
    HttpClientModule,
    DxLoadPanelModule,
    DxToastModule
  ]
})
export class EmployeeModule { }
