import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AdminTempComponent} from "./admin-temp/admin-temp.component";
import {HomeComponent} from "./home/home.component";
import {ProfileComponent} from "./profile/profile.component";
import {StudentsComponent} from "./students/students.component";
import {PaymentsComponent} from "./payments/payments.component";
import {LoadstudentsComponent} from "./loadstudents/loadstudents.component";
import {LoadpaymentsComponent} from "./loadpayments/loadpayments.component";
import {DashboardComponent} from "./dashboard/dashboard.component";
import {AuthGuard} from "./guards/auth.guard";
import {AuthorizationGuard} from "./guards/authorize.guard";


const routes: Routes = [
  {path: "", component: LoginComponent},
  {path: "login", component: LoginComponent},
  {
    path: "admin", component: AdminTempComponent,
    canActivate: [AuthGuard],
    children: [
      {path: "", pathMatch: "full", redirectTo: "home"},
      {path: "home", component: HomeComponent},
      {path: "dashboard", component: DashboardComponent},
      {path: "profile", component: ProfileComponent},
      {path: "students", component: StudentsComponent},
      {path: "payments", component: PaymentsComponent},
      {
        path: "loadStudents", component: LoadstudentsComponent,
        canActivate: [AuthorizationGuard], data: {roles: ['ADMIN']}
      },
      {
        path: "loadPayments", component: LoadpaymentsComponent,
        canActivate: [AuthorizationGuard], data: {roles: ['ADMIN']}
      },
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
