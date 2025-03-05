import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // Correct import

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MenuComponent } from './menu/menu.component';
import { RouterModule, Routes } from '@angular/router';
import { AdminShowComponent } from './admin-show/admin-show.component'; 
import { AdminAddComponent } from './admin-add/admin-add.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { MatSortModule } from '@angular/material/sort';
import { MatPaginatorModule } from '@angular/material/paginator';

import { CarShowComponent } from './car-show/car-show.component';
import { CarAddComponent } from './car-add/car-add.component';
import { CarUpdateComponent } from './car-update/car-update.component';
import { CarDeleteComponent } from './car-delete/car-delete.component';

import { CustShowComponent } from './cust-show/cust-show.component';
import { ResShowComponent } from './res-show/res-show.component';
import { PayShowComponent } from './pay-show/pay-show.component';
import { ReviewShowComponent } from './review-show/review-show.component';
import { RefundShowComponent } from './refund-show/refund-show.component';
import { RevenueByCarComponent } from './revenue-by-car/revenue-by-car.component';
import { RevenueByDateComponent } from './revenue-by-date/revenue-by-date.component';
import { RevenueByUserComponent } from './revenue-by-user/revenue-by-user.component';
import { AdminService } from './admin.service';

const routes: Routes = [
 // vibhuti shrivastava
  { path: '', component: LoginComponent },
  {path : 'signup',component:AdminAddComponent},
  {
    path: 'menu', component: MenuComponent, children: [
      { path: 'adminShow', component: AdminShowComponent, outlet: 'hexa' },
    
      {path:'carShow', component:CarShowComponent, outlet: 'hexa'},
      {path:'carAdd', component:CarAddComponent, outlet: 'hexa'},
      {path:'carUpdate', component:CarUpdateComponent, outlet: 'hexa'},
      {path:'deleteCar', component:CarDeleteComponent, outlet: 'hexa'},
      {path:'custShow', component:CustShowComponent, outlet: 'hexa'},
      {path:'resShow', component:ResShowComponent, outlet: 'hexa'},
      {path:'payShow', component:PayShowComponent, outlet: 'hexa'},
      {path:'reviewShow', component:ReviewShowComponent, outlet: 'hexa'},
      {path:'refundShow', component:RefundShowComponent, outlet: 'hexa'},
      {path:'revByCar', component:RevenueByCarComponent, outlet: 'hexa'},
      {path:'revByDate', component:RevenueByDateComponent, outlet: 'hexa'},
      {path:'revByUser', component:RevenueByUserComponent, outlet: 'hexa'}
    ]
  }
];

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuComponent,
    AdminShowComponent,
    AdminAddComponent,
    CarShowComponent,
    CarAddComponent,
    CarUpdateComponent,
    CarDeleteComponent,
    CustShowComponent,
    ResShowComponent,
    PayShowComponent,
    ReviewShowComponent,
    RefundShowComponent,
    RevenueByCarComponent,
    RevenueByDateComponent,
    RevenueByUserComponent
    
  ],
  imports: [
    BrowserModule,
    FormsModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    AppRoutingModule,
    MatTableModule,
    BrowserAnimationsModule,
    MatPaginatorModule,
    // CommonModule,
    MatInputModule,
    MatSelectModule,
    MatCardModule,
    MatSortModule
  ],
  providers: [AdminService],
  bootstrap: [AppComponent]
})
export class AppModule { }
