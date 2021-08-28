import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IamRoutingModule } from './iam-routing.module';
import { IamComponent } from './iam.component';
import {DxDataGridModule} from "devextreme-angular";
import {DetailGridModule} from "./detail-grid/detail-grid.module";


@NgModule({
  declarations: [
    IamComponent
  ],
  imports: [
    CommonModule,
    IamRoutingModule,
    DxDataGridModule,
    DetailGridModule
  ]
})
export class IamModule { }
