import { Component } from '@angular/core';
import { Car } from '../car';

import { AdminService } from '../admin.service';
import { NgForm } from '@angular/forms';
// vibhuti shrivastava
@Component({
  selector: 'app-car-add',
  templateUrl: './car-add.component.html',
  styleUrl: './car-add.component.css'
})
export class CarAddComponent {
  car : Car;
  result : string;

  constructor(private _adminService : AdminService) {
    this.car = new Car();
  }

  add(carForm : NgForm) {
   
    alert(""+this.car.make + " " +this.car.model+ " " +this.car.year+ " " +this.car.location
    + " " +this.car.fastag+ " " +this.car.price+ " " +this.car.availability+ " " +this.car.category
    + " " +this.car.fuelType+ " " +this.car.gearType);
   
      this._adminService.addCar(this.car).subscribe(x => {
        this.result = x;
      })

      alert("added successfull");
    
  }

}
