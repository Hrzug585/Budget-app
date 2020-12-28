import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { Expense } from "../models/expense";

@Injectable()
export class ImageService {
  constructor(private http: HttpClient) {}
  
  public uploadImage(image: File): Observable<any> {
    const formData = new FormData();

    formData.append('image', image);

    return this.http.post('http://localhost:9889/api/image/create', formData);
  }

  getImage(expense: Expense): Observable<{
    expenseId: number,
    image_id: number,
    pic: string
  }>{
    const id: string = <string><unknown>expense.expense_id;
    let link: string = 'http://localhost:9889/api/image/get/';
    link = link.concat(id);
    return this.http.get<{
      expenseId: number,
      image_id: number,
      pic: string
    }>(link);
  }
}