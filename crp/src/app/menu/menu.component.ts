import { Component } from '@angular/core';
import { Router } from '@angular/router'; 
// vibhuti shrivastava
@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent {

  constructor(private router: Router) {}

  resetPage() {
    window.location.reload();
    
  }

  logout() {
    localStorage.clear(); 

    this.router.navigate(['/']);
  }
}
