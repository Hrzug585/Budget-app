import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/internal/Observable";
import { Expense } from "../models/expense";

@Injectable()
export class ImageService {
  constructor(private http: HttpClient) {}
  
  public uploadImage(file: File, expense_id: string): Observable<any> {
    
    let url: string = 'http://localhost:9889/api/image/create/';
    url = url.concat(expense_id);

    const fd = new FormData();
    fd.append('image', file, file.name);

    return this.http.post(url, fd);
  }

  getImage(expense: Expense): Observable<{
    expenseId: number,
    image_id: number,
    pic: string
  }>{
    const id: string = <string><unknown>expense.expense_id;
    let url: string = 'http://localhost:9889/api/image/get/';
    url = url.concat(id);
    return this.http.get<{
      expenseId: number,
      image_id: number,
      pic: string
    }>(url);
  }
}