import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { DashboardComponent } from './dashboard.component';

const routes: Routes = [{
    path: '', component: DashboardComponent ,
    children: [
      { path: '', loadChildren: () => import('./profile/profile.module').then(m => m.ProfileModule) },
      { path: 'iam', loadChildren: () => import('./iam/iam.module').then(m => m.IamModule) },
      { path: 'employee', loadChildren: () => import('./employee/employee.module').then(m => m.EmployeeModule) }
    ],
  }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule { }
