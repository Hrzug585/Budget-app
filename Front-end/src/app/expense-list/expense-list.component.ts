import { DarkModeService } from './../services/darkmode.service';
import { ExpenseService } from './../services/expenses.service';
import { Component } from '@angular/core';
import { Expense } from '../models/expense';

@Component({
  selector: 'app-expense-list',
  templateUrl: 'expense-list.component.html',
  styleUrls: ['./expense-list.component.css'],
  providers: []
})

export class ExpenseListComponent {
  currentExpense?: Expense;
  expenses: Expense[] = []

  theme:string = 'lite';

  constructor(private expenseService: ExpenseService, private darkModeService: DarkModeService) {
    this.darkModeService.switchDarkMode.subscribe(
      (newStatus: string) => {this.theme = newStatus}
    );
   }

  ngOnInit() {
      this.expenseService.getExpenses().subscribe(data => {this.expenses = data});
  }
  
  onClick(expense: Expense){
    this.currentExpense = expense;
    // console.log(this.expenses);
  }

  isEmptyObject() {
    let isEmpty:boolean = true;
    if(!this.currentExpense) {
      isEmpty = false;
    }

    return isEmpty;
  }
}
