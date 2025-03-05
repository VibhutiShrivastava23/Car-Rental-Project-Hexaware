import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
// vibhuti shrivastava
@Component({
  selector: 'app-car-delete',
  templateUrl: './car-delete.component.html',
  styleUrl: './car-delete.component.css'
})
export class CarDeleteComponent {
  carid : number;
  result : any;
   constructor(private _adminService : AdminService) {
  
   }
   delete() {
    this._adminService.deleteCar(this.carid).subscribe(x => {
      this.result = x;
    })
    alert("deleted successfully");
   }
}
