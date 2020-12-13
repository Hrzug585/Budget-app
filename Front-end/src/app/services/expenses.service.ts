import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Expense } from '../models/expense';
import { EventEmitter } from '@angular/core';

@Injectable()
export class ExpenseService {
    expenseUpdated = new EventEmitter<{amount: number, name: string}[]>();

    expenses = [
        {
            amount: 25,
            name: 'Test expense1'
        },
        {
            amount: 55,
            name: 'Test expense 2'
        }
    ];

    constructor(private http: HttpClient) { }

    getExpenses(): void{
     this.http.get<Expense[]>("http://localhost:9889/api/expense/list/2")
        .subscribe(req => {
            let expenses = req.map(expense => ({amount: expense.amount, name: expense.name}))
            this.expenseUpdated.emit(expenses);
          });
    }

    addExpense(amount: number, name: string) {
        this.expenses.push({amount: amount, name: name});
    }

}