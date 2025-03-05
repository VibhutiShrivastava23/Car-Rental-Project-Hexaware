import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { MatTableDataSource } from '@angular/material/table';
import { Car } from '../car';
import { OnInit } from '@angular/core';
import { ViewChild } from '@angular/core';

import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
// vibhuti shrivastava
@Component({
  selector: 'app-car-show',
  templateUrl: './car-show.component.html',
  styleUrl: './car-show.component.css'
})
export class CarShowComponent  {
  displayedColumns: string[] = [
    'carid',
    'make',
    'model',
    'year',
    'location',
    'fastag',
    'price',
    'availability',
    'category',
    'fuelType',
    'gearType'
  ];

  car : Car[];
  dataSource = new MatTableDataSource<Car>();
  @ViewChild(MatSort) sort = {} as MatSort;
  @ViewChild(MatPaginator) paginator = {} as MatPaginator;


  selectedFilter: string = ''; 
  filterValue: string = ''; 

  onFilterChange() {
    if (this.filterValue) {
    switch (this.selectedFilter) {
      case 'category':
        this._adminService.searchByCategory(this.filterValue).subscribe(y => {
          this.car = y;
        });
        break;
      case 'availability':
        this._adminService.searchByAvailability(this.filterValue).subscribe(y => {
          this.car = y;
        });
        break;
      case 'fastag':
        this._adminService.searchByFastag(this.filterValue).subscribe(y => {
          this.car = y;
        });
        break;
      default:
        this.car = [];
        break;
    }
  }
  }
  constructor(private _adminService : AdminService) {
    this._adminService.showCar().subscribe((x: any) => {
      this.car = x;
      this.dataSource = new MatTableDataSource(this.car);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    })
   

  }
  // =====================================================
  selectedFilters: string = '';
  carid: number | undefined;    
  availability: string = '';    
  price: number | undefined;    
  fastag: string = '';  
 
 
    
    onSubmit() {
      // alert(this.availability)
      // alert(this.carid)
       switch (this.selectedFilters) {
       
        case "availability":
          
          if (this.carid && this.availability) {
            this._adminService.updateAvailability(this.carid, this.availability).subscribe(
              y => {
                alert("y")
                this.car = y;
                alert('Updated successfully');
              },
              error => {
                console.error('Error updating:', error);
              }
            );
          } else {
            alert("error in if")
          }
          break;
  
      case 'price':
        alert(this.price)
        if (this.carid && this.price) {
          this._adminService.updatePrice(this.carid, this.price).subscribe(
            y => {
              this.car = y;
              alert('Updated successfully');
            },
            error => {
              console.error('Error updating:', error);
            }
          );
        } else {
          alert("error in if")
        }
        break;
  
      case 'fastag':
        if (this.carid && this.fastag) {
          this._adminService.updateFastag(this.carid, this.fastag).subscribe(
            y => {
              this.car = y;
              alert('Updated successfully');
            },
            error => {
              console.error('Error updating:', error);
            }
          );
        } else {
          alert("error in if")
        }
        break;
  
      default:
        alert('Please select a valid update option');
    }
  }
  // ====================================================
  ngOnInit(): void {}
}
