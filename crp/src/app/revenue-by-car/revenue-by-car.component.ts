import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { Car } from '../car';
// vibhuti shrivastava
@Component({
  selector: 'app-revenue-by-car',
  templateUrl: './revenue-by-car.component.html',
  styleUrl: './revenue-by-car.component.css'
})
export class RevenueByCarComponent {
  carid: number | null = null; 
  revenue: number | null = null; 
  car: Car | null = null;

  constructor(private adminService: AdminService) {}

  fetchRevenueAndCarDetails(): void {
    if (this.carid !== null) {
      this.adminService.revenueByCar(this.carid).subscribe(
        (data: number) => {
          this.revenue = data;
        },
        (error) => {
          console.error('Error fetching revenue:', error);
          this.revenue = null;
        }
      );

      this.adminService.showCar().subscribe(
        (x: Car[]) => {
          this.car = x.find(car => car.carid === this.carid) || null; 
        },
        (error) => {
          console.error('Error fetching all cars:', error);
          this.car = null;
        }
      );
    }
  }


}
