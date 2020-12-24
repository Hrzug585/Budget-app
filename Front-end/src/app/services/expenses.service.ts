import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Account } from '../models/account';
import { Category } from '../models/category';
import { NewExpense, Expense } from '../models/expense';

@Injectable()
export class ExpenseService {


    constructor(private http: HttpClient) { }

    getExpenses(): Observable<Expense[]>{
     return this.http.get<Expense[]>("http://localhost:9889/api/expense/list/1");
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