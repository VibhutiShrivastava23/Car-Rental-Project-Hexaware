import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { MatTableDataSource } from '@angular/material/table';
import { OnInit } from '@angular/core';
import { ViewChild } from '@angular/core';
// vibhuti shrivastava
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { Payment } from '../payment';
@Component({
  selector: 'app-pay-show',
  templateUrl: './pay-show.component.html',
  styleUrl: './pay-show.component.css'
})
export class PayShowComponent {
  displayedColumns: string[] = [
    'payId',
    'userId',
    'resId',
    'amount',
    'paymentMethod',
    'status',
    'paymentPurpose',
    'payDate'
  ];

  payment : Payment[];
  dataSource = new MatTableDataSource<Payment>();
  @ViewChild(MatSort) sort = {} as MatSort;
  @ViewChild(MatPaginator) paginator = {} as MatPaginator;

  constructor(private _adminService : AdminService) {
    this._adminService.showPayment().subscribe((x: any) => {
      this.payment = x;
      this.dataSource = new MatTableDataSource(this.payment);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    })
   

  }
  
  selectedFilter: string = ''; 
  filterValue: number ; 

  onFilterChange() {
    if (this.filterValue) {
    if (this.selectedFilter) {
      
        this._adminService.searchByRes(this.filterValue).subscribe(y => {
          this.payment = y;
        });}
        else{
          alert("enter value")
        }
        
        
      }
    
    }
    ngOnInit(): void {}
  }
