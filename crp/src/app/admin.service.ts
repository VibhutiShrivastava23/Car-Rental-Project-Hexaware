import { Injectable } from '@angular/core';
import { Admin } from './admin';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from './car';

// vibhuti shrivastava

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private _http : HttpClient) { }
  login(email : string, password : string) : Observable<any> {
    return this._http.get("http://localhost:2300/admin/login/"+email+"/"+password);
  }

  showAdmin() : Observable<any> {
    return this._http.get("http://localhost:2300/admin/showAdmin");
  }

  addAdmin(admin : Admin) : Observable<any> {
    return this._http.post("http://localhost:2300/admin/addAdmin",admin);
  }
// car controller
  showCar() : Observable<any> {
    return this._http.get("http://localhost:2300/admin/showCar");
  }
  addCar(car : Car) : Observable<any> {
    return this._http.post("http://localhost:2300/admin/addCar",car);
  }

  searchByCategory(category : string) : Observable<any> {
    return this._http.get("http://localhost:2300/admin/searchCarByCategory/" +category);
  }
  searchByFastag(fastag : string) : Observable<any> {
    return this._http.get("http://localhost:2300/admin/searchCarByFastag/" +fastag);
  }
  searchByAvailability(availability : string) : Observable<any> {
    return this._http.get("http://localhost:2300/admin/searchCarByAvail/" +availability);
  }
  updateCarDetail(car:Car) : Observable<any> {
    return this._http.put("http://localhost:2300/admin/updateCarDetail",car);
   }
 updateAvailability(carid : number,availability:string) : Observable<any> {
   return this._http.put("http://localhost:2300/admin/updateAvail/" +carid+"/"+availability,{}, { responseType: 'text' });
  }
 updatePrice(carid : number,price:number) : Observable<any> {
   return this._http.put("http://localhost:2300/admin/updatePrice/"+carid+"/"+price,{}, { responseType: 'text' });
 }
 updateFastag(carid : number,fastag:string) : Observable<any> {
   return this._http.put("http://localhost:2300/admin/updateFastag/"+carid+"/"+ fastag,{}, { responseType: 'text' });
 }
 deleteCar(carid : number) : Observable<any> {
   return this._http.delete("http://localhost:2300/admin/deleteCar/"+carid);
 }
// user controller
showCustomer() : Observable<any> {
  return this._http.get("http://localhost:2300/admin/showCustomer");
}
updateCustStatus(userId : number,status:string) : Observable<any> {
  return this._http.put("http://localhost:2300/admin/updateStatus/"+userId+"/"+ status,{}, { responseType: 'text' });
}
// reservation controller
showReservation() : Observable<any> {
  return this._http.get("http://localhost:2300/admin/showReservation");
}
updateResStatus(resId : number,status:string) : Observable<any> {
  return this._http.put("http://localhost:2300/admin/updateResvStatus/"+resId+"/"+ status,{}, { responseType: 'text' });
}
// payment controller
showPayment() : Observable<any> {
  return this._http.get("http://localhost:2300/admin/showPayment");
}
searchByRes(resId : number) : Observable<any> {
  return this._http.get("http://localhost:2300/admin/searchPaymentByReservation/" +resId);
}
// review controller
showReview() : Observable<any> {
  return this._http.get("http://localhost:2300/admin/showReview");
}
searchByReview(userId : number) : Observable<any> {
  return this._http.get("http://localhost:2300/admin/searchReview/" +userId);
}
// refund controller
showRefund() : Observable<any> {
  return this._http.get("http://localhost:2300/admin/showRefund");
}
updateRefundStatus(refundId : number,refundStatus:string) : Observable<any> {
  return this._http.put("http://localhost:2300/admin/updateRefundStatus/"+refundId+"/"+ refundStatus,{}, { responseType: 'text' });
}
// generateing reports
revenueByCar(carId : number) : Observable<any> {
  return this._http.get("http://localhost:2300/admin/revenueByCar/" +carId);
} 
revenueByDate(startDate: string, endDate: string): Observable<any>{
  return this._http.get("http://localhost:2300/admin/revenueReportByDate/" +startDate+"/"+endDate,{})
}
revenueByUser(userId : number) : Observable<any> {
  return this._http.get("http://localhost:2300/admin/revenueByCust/" +userId);
}
}
