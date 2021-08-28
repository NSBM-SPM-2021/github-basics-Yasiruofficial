import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { IamComponent } from './iam.component';

const routes: Routes = [{ path: '', component: IamComponent },
  { path: 'detail-grid', loadChildren: () => import('./detail-grid/detail-grid.module').then(m => m.DetailGridModule) }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class IamRoutingModule { }
