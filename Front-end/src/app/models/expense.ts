
export class Expense {
    expense_id: number;
    name: string;
    timestamp: string;
    category_id: number;
    account_id: number;
    amount: number;

    constructor(expense_id: number,
        name: string,
        timestamp: string,
        category_id: number,
        account_id: number,
        amount: number) {
            this.expense_id = expense_id;
            this.expense_id = expense_id;
            this.name = name;
            this.timestamp = timestamp;
            this.category_id = category_id;
            this.account_id = account_id;
            this.amount = amount;
        }
}