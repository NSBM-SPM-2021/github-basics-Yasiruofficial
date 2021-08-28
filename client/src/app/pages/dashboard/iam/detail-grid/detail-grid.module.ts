import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { DetailGridRoutingModule } from './detail-grid-routing.module';
import { DetailGridComponent } from './detail-grid.component';
import {DxDataGridModule} from "devextreme-angular";


@NgModule({
  declarations: [
    DetailGridComponent
  ],
  exports: [
    DetailGridComponent
  ],
  imports: [
    CommonModule,
    DetailGridRoutingModule,
    DxDataGridModule
  ]
})
export class DetailGridModule { }
