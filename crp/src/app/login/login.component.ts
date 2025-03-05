import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AdminService } from '../admin.service';
// vibhuti shrivastava
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})

export class LoginComponent {

  email : string;
  password  : string;
  constructor(private _adminService : AdminService,
        private _router : Router
  ) {

  }

  login()
   {
    this._adminService.login(this.email,this.password).subscribe(x => {
      alert("login")
      if (x===1) {
        this._router.navigate(['/menu']);
        alert("Correct");
        alert("Welcome to Admin Dashboard");
      } else {
        alert("Invalid")
      }
    })
  }
  goToSignUp() {
    this._router.navigate(['/signup']);  }
}
