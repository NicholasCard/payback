import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';


import { AppComponent } from './app.component';
import { RequestsComponent } from './requests/requests.component';
import { LoginComponent } from './site/login.component';
import { FormsModule } from '@angular/forms';
import { HomeComponent } from './site/home.component';
import { RouterModule, Routes } from '@angular/router';
import { AuthGuard } from './site/auth.guard';

const routes:Routes = [
  { path: '', component: HomeComponent, canActivate: [AuthGuard], children: 
    [{ path: 'requests', component: RequestsComponent }] },
  { path: 'login', component: LoginComponent }
]

@NgModule({
  declarations: [
    AppComponent,
    RequestsComponent,
    LoginComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
