import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { Product } from '../common/product';
import { ProductList } from '../common/product-list';

@Injectable({
  providedIn: 'root'
})
export class ProductService {


  private url = 'http://localhost:8080/api/products';
  private urlLists = 'http://localhost:8080/api/shoppingLists';

  constructor(private httpClient: HttpClient) { }


  getProducts(theListId: number): Observable<Product[]> {
    const searchUrl = `${this.url}/search/findAllByListId?id=${theListId}`
    return this.getProductsByUrl(searchUrl);

  }

  getProductLists(): Observable<ProductList[]> {
    return this.httpClient.get<GetResponseProductList>(this.urlLists).pipe(
      map(response => response._embedded.shoppingLists)
    )
  }
  searchProducts(theKeyword: string): Observable<Product[]> {
    const searchUrl = `${this.url}/search/findByNameContaining?name=${theKeyword}`;
    return this.getProductsByUrl(searchUrl);
  }


  private getProductsByUrl(searchUrl: string): Observable<Product[]> {
    return this.httpClient.get<GetResponseProducts>(searchUrl).pipe(
      map(response => response._embedded.products)
    );
  }
}
interface GetResponseProducts {
  _embedded: {
    products: Product[];
  }
}

interface GetResponseProductList {
  _embedded: {
    shoppingLists: ProductList[];
  }
}