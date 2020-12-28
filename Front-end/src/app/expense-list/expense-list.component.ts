import { DarkModeService } from './../services/darkmode.service';
import { ExpenseService } from './../services/expenses.service';
import { Component } from '@angular/core';
import { Expense } from '../models/expense';
import { ImageService } from '../services/image.service';
import { DomSanitizer } from '@angular/platform-browser';

@Component({
  selector: 'app-expense-list',
  templateUrl: 'expense-list.component.html',
  styleUrls: ['./expense-list.component.css'],
  providers: []
})

export class ExpenseListComponent {
  currentExpense?: Expense;
  currentImage?: any;
  expenses: Expense[] = []

  theme:string = 'lite';

  constructor(private expenseService: ExpenseService, private darkModeService: DarkModeService, private imageService: ImageService,private sanitizer: DomSanitizer) {
    this.darkModeService.switchDarkMode.subscribe(
      (newStatus: string) => {this.theme = newStatus}
    );
   }

  ngOnInit() {
      this.expenseService.getExpenses().subscribe(data => {this.expenses = data});
  }
  
  onClick(expense: Expense){
    this.currentExpense = expense;
    this.imageService.getImage(expense).subscribe(ret => {
      if(ret != null){
        let objectURL = 'data:image/png;base64,' + ret.pic;
        this.currentImage = this.sanitizer.bypassSecurityTrustUrl(objectURL);
      } else {
        this.currentImage = null;
      }
    });
  }

  isEmptyObject() {
    let isEmpty:boolean = true;
    if(!this.currentExpense) {
      isEmpty = false;
    }

    return isEmpty;
  }

  hasImage() {
    let hasImage:boolean = true;
    if(!this.currentImage) {
      hasImage = false;
    }
    
    return hasImage;
  }
}
