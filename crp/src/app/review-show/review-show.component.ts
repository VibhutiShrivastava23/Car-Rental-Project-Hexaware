import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { MatTableDataSource } from '@angular/material/table';
import { OnInit } from '@angular/core';
import { ViewChild } from '@angular/core';

import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { Review } from '../review';
// vibhuti shrivastava
@Component({
  selector: 'app-review-show',
  templateUrl: './review-show.component.html',
  styleUrl: './review-show.component.css'
})
export class ReviewShowComponent {
  displayedColumns: string[] = [
    'revId',
    'userId',
    'rating',
    'review'
  ];

  review : Review[];
  dataSource = new MatTableDataSource<Review>();
  @ViewChild(MatSort) sort = {} as MatSort;
  @ViewChild(MatPaginator) paginator = {} as MatPaginator;

  constructor(private _adminService : AdminService) {
    this._adminService.showReview().subscribe((x: any) => {
      this.review = x;
      this.dataSource = new MatTableDataSource(this.review);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    })
   

  }
  
  selectedFilter: string = ''; 
  filterValue: number ; 

  onFilterChange() {
    
      if (this.filterValue) {
        if (this.selectedFilter) {
          
            this._adminService.searchByReview(this.filterValue).subscribe(y => {
              this.review = y;
            });}
            else{
              alert("enter value")
            }
            
            
      
    
    }}
    ngOnInit(): void {}
}
