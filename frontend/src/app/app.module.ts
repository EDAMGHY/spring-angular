import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {provideAnimationsAsync} from '@angular/platform-browser/animations/async';
import {ReactiveFormsModule} from "@angular/forms";

import {AdminTempComponent} from './admin-temp/admin-temp.component';
import {LoginComponent} from './login/login.component';
import {HomeComponent} from './home/home.component';
import {StudentsComponent} from './students/students.component';
import {PaymentsComponent} from './payments/payments.component';
import {ProfileComponent} from './profile/profile.component';

// ANGULAR MATERIAL
import {MatCardModule} from "@angular/material/card";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {HttpClientModule} from "@angular/common/http";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatSortModule} from "@angular/material/sort";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatButtonModule} from "@angular/material/button";
import {MatIconModule} from "@angular/material/icon";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatListModule} from "@angular/material/list";
import {MatMenuModule} from "@angular/material/menu";
import {DashboardComponent} from './dashboard/dashboard.component';
import {LoadstudentsComponent} from './loadstudents/loadstudents.component';
import {LoadpaymentsComponent} from './loadpayments/loadpayments.component';


import {AuthGuard} from "./guards/auth.guard";
import {AuthorizationGuard} from "./guards/authorize.guard";

@NgModule({
  declarations: [
    AppComponent,
    AdminTempComponent,
    LoginComponent,
    HomeComponent,
    StudentsComponent,
    PaymentsComponent,
    ProfileComponent,
    DashboardComponent,
    LoadstudentsComponent,
    LoadpaymentsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatToolbarModule,
    MatButtonModule,
    MatIconModule,
    MatSidenavModule,
    MatListModule,
    MatMenuModule,
    MatCardModule,
    MatFormFieldModule,
    MatInputModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule
  ],
  providers: [
    provideAnimationsAsync(),
    AuthGuard,
    AuthorizationGuard
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
