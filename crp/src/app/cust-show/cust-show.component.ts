import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { ViewChild } from '@angular/core';

import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Customer } from '../customer';

// vibhuti shrivastava
@Component({
  selector: 'app-cust-show',
  templateUrl: './cust-show.component.html',
  styleUrl: './cust-show.component.css'
})
export class CustShowComponent {
  displayedColumns: string[] = [
    'userId',
'firstname',
'lastname',
'city',
'state',
'address',
'phoneno',
'email',
'status'
  ];
  customer : Customer[];
  result : string;
  dataSource = new MatTableDataSource<Customer>();
  @ViewChild(MatSort) sort = {} as MatSort;
  @ViewChild(MatPaginator) paginator = {} as MatPaginator;


  constructor(private _adminService : AdminService) {
    this._adminService.showCustomer().subscribe(x => {
      this.customer = x;
      this.dataSource = new MatTableDataSource(this.customer);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      
      
    })
   

  }
  

// =====================================================
  
  selectedFilter: string = '';  
  userId: number | undefined;    
  status: string = '';    
   
 
 
    
    onSubmit() {

          if (this.userId && this.status) {
            alert(this.userId)
            
            this._adminService.updateCustStatus(this.userId, this.status).subscribe(
              y => {
                this.customer = y;
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
