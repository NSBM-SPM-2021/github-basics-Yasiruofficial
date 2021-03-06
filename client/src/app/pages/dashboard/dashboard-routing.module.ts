import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {DashboardComponent} from './dashboard.component';

const routes: Routes = [
  {  path: '',
    component: DashboardComponent,
    children: [
      { path: 'employee', loadChildren: () => import('./employee/employee.module').then(m => m.EmployeeModule) },
      { path: '', loadChildren: () => import('./info/info.module').then(m => m.InfoModule) },
    ],
  },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class DashboardRoutingModule {
}
