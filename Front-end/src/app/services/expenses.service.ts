export class ExpenseService {
    expenses = [
        {
            amount: 25,
            name: 'Test expense1'
        },
        {
            amount: 55,
            name: 'Test expense 2'
        }
    ];

    getExpenses(): any[]{
        return this.expenses;
    }

    addExpense(amount: number, name: string) {
        this.expenses.push({amount: amount, name: name});
    }

}