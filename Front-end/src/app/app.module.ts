import { MainComponent } from './root/main.component';
import { ExpenseService } from './services/expenses.service';
import { DarkModeService } from './services/darkmode.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header/header.component';
import { Toggle } from './toggle/toggle.component';
import { ExpenseListComponent } from './expense-list/expense-list.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    Toggle,
    ExpenseListComponent,
    MainComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [DarkModeService, ExpenseService],
  bootstrap: [AppComponent]
})
export class AppModule { }
