import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DetailGridComponent } from './detail-grid.component';

const routes: Routes = [{ path: '', component: DetailGridComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DetailGridRoutingModule { }
