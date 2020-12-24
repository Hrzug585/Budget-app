export class Category {
    category_id: number;
    category_name: string;
    account_id: number;

    constructor(category_id: number,
        category_name: string,
        account_id: number) {
            this.account_id = account_id;
            this.category_id = category_id;
            this.category_name = category_name;
        }
}