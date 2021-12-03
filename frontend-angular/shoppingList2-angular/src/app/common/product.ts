import { User } from "./user";

export class Product {
 id: number | undefined;
 name: string | undefined;
 count: number | undefined;
 bought: boolean | undefined;
 addedBy: User | undefined;
 /*shoppingList: ShoppingList | undefined;*/
}
