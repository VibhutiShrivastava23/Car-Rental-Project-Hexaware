import { Component } from '@angular/core';
import { AdminService } from '../admin.service';
import { Car } from '../car';
import { NgForm } from '@angular/forms';
// vibhuti shrivastava

@Component({
  selector: 'app-car-update',
  templateUrl: './car-update.component.html',
  styleUrl: './car-update.component.css'
})
export class CarUpdateComponent {

  car: Car = new Car();
  result : string;
  constructor(private _adminService : AdminService) {
    this.car ;
    
  }
  
// ===========================================================
 submit(carForm : NgForm) {
    alert(""+this.car.make + " " +this.car.model+ " " +this.car.year+ " " +this.car.location
    + " " +this.car.fastag+ " " +this.car.price+ " " +this.car.availability+ " " +this.car.category
    + " " +this.car.fuelType+ " " +this.car.gearType);
   
      this._adminService.updateCarDetail(this.car).subscribe(x => {
        this.result = x;
      })

      alert("updated successfull");
    
  }

 }


