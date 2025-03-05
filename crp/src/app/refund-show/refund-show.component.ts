import { Component } from '@angular/core';
import { Refund } from '../refund';
import { AdminService } from '../admin.service';
import { ViewChild } from '@angular/core';

import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
// vibhuti shrivastava
@Component({
  selector: 'app-refund-show',
  templateUrl: './refund-show.component.html',
  styleUrl: './refund-show.component.css'
})
export class RefundShowComponent {
  refund : Refund[];
  result : string;
  dataSource = new MatTableDataSource<Refund>();
  @ViewChild(MatSort) sort = {} as MatSort;
  @ViewChild(MatPaginator) paginator = {} as MatPaginator;


  displayedColumns: string[] = [
    'refundId',
    'userId',
    'payId',
    'refundAmount',
    'refundDate',
    'refundMethod',
    'refundStatus'
  ];

  constructor(private _adminService : AdminService) {
    this._adminService.showRefund().subscribe(x => {
      this.refund = x;
      this.dataSource = new MatTableDataSource(this.refund);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      
      
    })
  }
  // =============================================
  selectedFilter: string = '';  
  refundId: number | undefined;    
  refundStatus: string = '';    
    
    onSubmit() {

          if (this.refundId && this.refundStatus) {
            alert(this.refundId)
            
            this._adminService.updateRefundStatus(this.refundId, this.refundStatus).subscribe(
              y => {
                this.refund = y;
                alert('Updated successfully');
              },
              error => {
                console.error('Error updating:', error);
              }
            );
          } else {alert("enter valid data");
            
          }
        }
  ngOnInit(): void {}
}
