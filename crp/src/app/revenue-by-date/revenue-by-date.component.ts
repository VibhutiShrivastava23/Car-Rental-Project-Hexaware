import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
// vibhuti shrivastava
@Component({
  selector: 'app-revenue-by-date',
  templateUrl: './revenue-by-date.component.html',
  styleUrl: './revenue-by-date.component.css'
})
export class RevenueByDateComponent {
  startDate: string = '';
  endDate: string = '';
  revenue: number | null = null;

  constructor(private adminService: AdminService) {}

  fetchRevenueReport(): void {
    if (this.startDate && this.endDate) {
      this.adminService.revenueByDate(this.startDate, this.endDate).subscribe(
        (data: number | null) => {
          this.revenue = data; 
        },
        (error) => {
          console.error('Error fetching revenue report:', error);
          this.revenue = null; 
        }
      );
    }
  }

}
