export class NewExpense {
    amount: number;
    category_id: number;
    name?: string;
    description?: string;
    account_id: number;

    constructor(amount: number, category_id: number, account_id: number, name?: string, description?: string) {
        this.amount = amount
        this.category_id = category_id;
        this.account_id = account_id;
        this.name = name;
        this.description = description;
    }
}


export class Expense extends NewExpense{
    expense_id: number;
    timestamp: string;
    category_id: number;
    account_id: number;
    amount: number;
    description: string;
    name: string;

    constructor(expense_id: number,
        timestamp: string,
        category_id: number,
        account_id: number,
        amount: number,
        name: string,
        description: string,
        category: string) {
            super(amount, category_id, account_id);

            this.expense_id = expense_id;
            this.expense_id = expense_id;
            this.name = name;
            this.timestamp = timestamp;
            this.category_id = category_id;
            this.account_id = account_id;
            this.amount = amount;
            this.description = description;
        }
}