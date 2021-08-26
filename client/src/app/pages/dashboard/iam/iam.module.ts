import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { IamRoutingModule } from './iam-routing.module';
import { IamComponent } from './iam.component';


@NgModule({
  declarations: [
    IamComponent
  ],
  imports: [
    CommonModule,
    IamRoutingModule
  ]
})
export class IamModule { }
