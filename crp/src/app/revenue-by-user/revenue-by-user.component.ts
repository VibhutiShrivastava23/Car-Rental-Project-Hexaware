import { Component } from '@angular/core';
import { Customer } from '../customer';
import { AdminService } from '../admin.service';
// vibhuti shrivastava
@Component({
  selector: 'app-revenue-by-user',
  templateUrl: './revenue-by-user.component.html',
  styleUrl: './revenue-by-user.component.css'
})
export class RevenueByUserComponent {
  userId: number | null = null; 
  revenue: number | null = null; 
  user: Customer | null = null; 

  constructor(private adminService: AdminService) {}

  fetchRevenueAndUserDetails(): void {
    if (this.userId !== null) {
      this.adminService.revenueByUser(this.userId).subscribe(
        (data: number) => {
          this.revenue = data;
        },
        (error) => {
          console.error('Error fetching revenue:', error);
          this.revenue = null;
        }
      );

      this.adminService.showCustomer().subscribe(
        (users: Customer[]) => {
         
          this.user = users.find(user => user.userId === this.userId) || null;
        },
        (error) => {
          console.error('Error fetching user details:', error);
          this.user = null;
        }
      );
    }
  }
  }


