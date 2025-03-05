import { Component } from '@angular/core';
import { Admin } from '../admin';
import { AdminService } from '../admin.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
// vibhuti shrivastava
@Component({
  selector: 'app-admin-add',
  templateUrl: './admin-add.component.html',
  styleUrl: './admin-add.component.css'
})
export class AdminAddComponent {
  admin: Admin = new Admin();
  confirmPassword: string = '';

  constructor(private adminService: AdminService, private router: Router) {}

  add(adminForm: NgForm) {
    this.adminService.showAdmin().subscribe(adminList => {
      const emailExists = adminList.some((admin: Admin) => admin.email === this.admin.email);

      if (emailExists) {
        alert("Email already exists!");
      } else {
        if (this.admin.password === this.confirmPassword) {
          this.adminService.addAdmin(this.admin).subscribe(response => {
            alert("Admin added successfully");
            adminForm.resetForm(); 
          });
        } else {
          alert("Passwords do not match!");
        }
      }
    });
  }

  goBack() {
    this.router.navigate(['/']); 
  }
} 