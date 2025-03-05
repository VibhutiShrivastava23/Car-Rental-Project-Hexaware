import { Component } from '@angular/core';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';
import { ViewChild } from '@angular/core';

import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
// vibhuti shrivastava
@Component({
  selector: 'app-admin-show',
  templateUrl: './admin-show.component.html',
  styleUrl: './admin-show.component.css'
})
export class AdminShowComponent  {
  displayedColumns: string[] = [
    'adminId',
    'email'
  ];

  admin : Admin[];
  dataSource = new MatTableDataSource<Admin>();
  @ViewChild(MatSort) sort = {} as MatSort;
  @ViewChild(MatPaginator) paginator = {} as MatPaginator;


  constructor(private _adminService : AdminService) {
    this._adminService.showAdmin().subscribe(x => {
      this.admin = x;
      this.dataSource = new MatTableDataSource(this.admin);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
      
      
    })
   

  }
  ngOnInit(): void {}
}