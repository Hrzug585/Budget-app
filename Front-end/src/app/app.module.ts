import { HttpClientModule } from '@angular/common/http';
import { ExpenseService } from './services/expenses.service';
import { DarkModeService } from './services/darkmode.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header/header.component';
import { Toggle } from './toggle/toggle.component';
import { ExpenseListComponent } from './expense-list/expense-list.component';
import { AddExpenseComponent } from './add-expense/add-expense.component';
import { MainComponent } from './root/main.component';
import { AppRoutingModule } from './app-routing.module';
import { ReactiveFormsModule } from '@angular/forms';
import { ImageUploadComponent } from './expense-list/image-upload/image-upload.component';
import { ImageService } from './services/image.service';
import { DownloadDataComponent } from './download-data/download-data.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    Toggle,
    ExpenseListComponent,
    MainComponent,
    AddExpenseComponent,
    ImageUploadComponent,
    DownloadDataComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    AppRoutingModule,
    ReactiveFormsModule
  ],
  providers: [DarkModeService, ExpenseService, ImageService],
  bootstrap: [AppComponent]
})
export class AppModule { }
