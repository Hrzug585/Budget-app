import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { Category } from '../models/category';
import { Expense, NewExpense } from '../models/expense';
import { ExpenseService } from '../services/expenses.service';

@Component({
  selector: 'app-add-expense',
  templateUrl: './add-expense.component.html',
  styleUrls: ['./add-expense.component.css']
})
export class AddExpenseComponent implements OnInit {
  categories: Category[] = [];
  expenseForm = new FormGroup({
    name: new FormControl(),
    amount: new FormControl('', Validators.required),
    description: new FormControl(),
    category: new FormControl('', Validators.required)
  })

  onSubmit() {
    const name: string = this.expenseForm.value.name;
    const amount: number = this.expenseForm.value.amount;
    const description: string = this.expenseForm.value.description;
    const category_id: number = this.expenseForm.value.category.category_id;
    const account_id: number = 1;

    const newExpense = new NewExpense(amount, category_id, account_id, name, description);
    this.expenseService.addExpense(newExpense).subscribe(data =>{
      console.log(data);
    });
    if(this.expenseForm.valid) {
      this.expenseForm.reset();
    }

  }

  onClick() {
    this.expenseService.getCategories().subscribe(account => {
      this.categories = account.categoryList;
    });
  }

  constructor(private expenseService: ExpenseService) { }

  ngOnInit(): void {
    this.expenseService.getCategories().subscribe(account => {
      this.categories = account.categoryList;
    });
  }
}
