import { DarkModeService } from './../../services/darkmode.service';
import { Component, EventEmitter, OnInit } from '@angular/core';
import { ExpenseService } from 'src/app/services/expenses.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component-light.css'],
  providers: []
})
export class HeaderComponent implements OnInit {
  theme:string = 'lite';
  expenseUpdated = new EventEmitter();

  constructor(private darkModeService: DarkModeService, private expenseService: ExpenseService) {
    this.darkModeService.switchDarkMode.subscribe(
      (newStatus: string) => {this.theme = newStatus}
    );
   }

  ngOnInit(): void {
  }

  onModeSwitch() {
    this.darkModeService.onUpdate(this.theme);
    // this.darkMode = !this.darkMode;
    // console.log(this.darkMode);
  }

  onClick() {
    this.expenseService.getExpenses();
  }

}
