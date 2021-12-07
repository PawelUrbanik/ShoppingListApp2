import { Product } from "./product";

export class ShoppingList {
    id: number | undefined;
    name: string | undefined;
    description: string | undefined;
    products: Product[] | undefined;
}
