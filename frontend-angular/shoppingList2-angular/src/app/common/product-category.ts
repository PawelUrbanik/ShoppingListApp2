import { Product } from "./product";

export class ProductCategory {

    id: number|undefined;
    categoryName: string | undefined;
    imageUrl: string | undefined;
    products: Product[] | undefined;
}
