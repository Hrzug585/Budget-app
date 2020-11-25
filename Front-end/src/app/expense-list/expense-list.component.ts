import { ExpenseService } from './../services/expenses.service';
import { Component } from '@angular/core';
import { listLazyRoutes } from '@angular/compiler/src/aot/lazy_routes';

@Component({
  selector: 'app-expense-list',
  templateUrl: 'expense-list.component.html',
  styleUrls: ['./expense-list.component.css'],
  providers: []

})
export class ExpenseListComponent {
  expenses: {amount: number, name: string}[] = []

  constructor(private expenseService: ExpenseService) {}

  ngOnInit() {
    this.expenses = this.expenseService.getExpenses();
  }
  
  onClick(){
    console.log("click");
  }
}
