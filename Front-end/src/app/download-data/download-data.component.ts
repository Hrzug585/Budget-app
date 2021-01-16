import { Component, OnInit } from '@angular/core';
import * as XLSX from 'xlsx';
import { ExpenseService } from '../services/expenses.service';
import { saveAs } from 'file-saver';


type AOA = any[][];
@Component({
  selector: 'app-download-data',
  templateUrl: "download-data.component.html",
  styles: [`
  .container {
    margin-top: 25px;
    width: 80%;
    border-radius: 25px;
    background-color: #f2f2f2;
    padding: 20px;
}`
  ]
})
export class DownloadDataComponent implements OnInit{
	data: AOA;
	workbook: any;
	sheet: AOA;
	wopts: XLSX.WritingOptions = { bookType: 'xlsx', type: 'array' };

  
	constructor(private expenseService: ExpenseService) { 
		this.data = <AOA>[[],[]];
		this.workbook = <AOA>[[],[]];
		this.sheet = <AOA>[[],[]];

		// this.expenseService.getExpenses().subscribe(
		// 	expenseData => {
		// 		this.workbook = XLSX.utils.book_new();
		// 		var ws = XLSX.utils.json_to_sheet(expenseData);
		// 		// XLSX.utils.book_append_sheet(this.workbook, ws);
				
		// 		expenseData.forEach(element => {
		// 			this.sheet.push([[element.expense_id],[element.amount]]);
		// 		});
		// 	}
		// );

	}

	exportExpensesJSON() {
		this.expenseService.getExpenses().subscribe(
			expenseData => {

				var FileSaver = require('file-saver');
				var blob = new Blob([JSON.stringify(expenseData)], {type: "text/plain;charset=utf-8"});
				FileSaver.saveAs(blob, "YourExport.json");
			}
		);
	}

	exportExpensesXLSX() {
		this.expenseService.getExpenses().subscribe(
			expenseData => {

				var filename = "YourExport.xlsx";
				var ws_name = "Expenses";
				var wb = XLSX.utils.book_new();
				var ws = XLSX.utils.json_to_sheet(expenseData);
		
				/* Add worksheet to workbook */
				XLSX.utils.book_append_sheet(wb, ws, ws_name);

				XLSX.writeFile(wb, filename);
			}
		);
	}

  ngOnInit(): void {}
	
}
