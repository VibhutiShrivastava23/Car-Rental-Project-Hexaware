import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { ViewChild } from '@angular/core';

import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Reservation } from '../reservation';
// vibhuti shrivastava
@Component({
  selector: 'app-res-show',
  templateUrl: './res-show.component.html',
  styleUrl: './res-show.component.css'
})
export class ResShowComponent {
  reservation : Reservation[];
  result : string;
  dataSource = new MatTableDataSource<Reservation>();
  @ViewChild(MatSort) sort = {} as MatSort;
  @ViewChild(MatPaginator) paginator = {} as MatPaginator;


  displayedColumns: string[] = [
    'resId',
    'userId',
    'carid',
    'pickupDate',
    'dropDate',
    'totalCost',
    'advanceAmount',
    'status',
    'dateOfReservation'
  ];

  constructor(private _adminService : AdminService) {
    this._adminService.showReservation().subscribe(x => {
      this.reservation = x;
      this.dataSource = new MatTableDataSource(this.reservation);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      
      
    })
   

  }
  // ===============================================================
  selectedFilter: string = '';  
  resId: number | undefined;    
  status: string = '';    
    
    onSubmit() {

          if (this.resId && this.status) {
            alert(this.resId)
            
            this._adminService.updateResStatus(this.resId, this.status).subscribe(
              y => {
                this.reservation = y;
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
