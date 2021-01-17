import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../models/account';
import { Category } from '../models/category';
import { NewExpense, Expense } from '../models/expense';

@Injectable()
export class ExpenseService {
    user: string = '1';

    constructor(private http: HttpClient) { }

    getExpenses(): Observable<Expense[]>{
        const url = 'http://localhost:9889/api/expense/list/1';
          
        // this.http.get<Expense[]>(url).subscribe( resp => {
        //     console.log(resp);
        // });
        
        // use case of XMLHTTPRequest from HTML5 API//
        var xmlhttp = new XMLHttpRequest();

        xmlhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                var myArr = JSON.parse(this.responseText);
                console.log(myArr);
            }
        };
        xmlhttp.open("GET", url, true);
        xmlhttp.send();
        // use case of XMLHTTPRequest from HTML5 API//
        
        return this.http.get<Expense[]>(url);
    }

    getCategories(): Observable<Account> {
        return this.http.get<Account>("http://localhost:9889/api/account/1");
    }

    addExpense(expense: NewExpense): Observable<Expense>{

        const headerDict = {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'Access-Control-Allow-Headers': 'Content-Type',
        };
        const requestOptions = {                                                                                                                                                                                 
            headers: new HttpHeaders(headerDict), 
        };

        //TODO
        //Add category id and account id
        console.log(expense);
        return this.http.post<Expense>("http://localhost:9889/api/expense/create", expense, requestOptions);
        
    }

}