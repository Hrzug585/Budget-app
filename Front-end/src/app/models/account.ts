import { Category } from "./category";
import { Expense } from "./expense";

export class Account {
    account_id: number;
    account_created: string;
    account_name: string;
    account_deleted: string;

    expenseList: Expense[];
    categoryList: Category[];

    constructor(account_id: number,
        account_created: string,
        account_name: string,
        account_deleted: string,
        expenseList: Expense[],
        categoryList: Category[]) {
            this.account_created = account_created;
            this.account_id = account_id;
            this.account_name = account_name;
            this.account_deleted = account_deleted;
            this.expenseList = expenseList;
            this.categoryList =  categoryList; 
        }
}