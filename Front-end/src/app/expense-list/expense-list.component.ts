import { DarkModeService } from './../services/darkmode.service';
import { ExpenseService } from './../services/expenses.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-expense-list',
  templateUrl: 'expense-list.component.html',
  styleUrls: ['./expense-list.component.css'],
  providers: []

})

export class ExpenseListComponent {
  expense?: {amount: number, name: string};
  expenses: {amount: number, name: string}[] = []
  theme:string = 'lite';
  expenseService: ExpenseService;

  constructor(expenseService: ExpenseService, private darkModeService: DarkModeService) {
    this.expenseService = expenseService;
    this.darkModeService.switchDarkMode.subscribe(
      (newStatus: string) => {this.theme = newStatus}
    );
   }


  ngOnInit() {
    this.expenses = this.expenseService.getExpenses();
  }
  
  onClick(index: number){
    this.expense = this.expenses[index];
  }

  isEmptyObject() {
    let isEmpty:boolean = true;
    if(!this.expense) {
      isEmpty = false;
    }

    return isEmpty;
  }
}
