import { HttpClient, HttpClientModule } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ProductCategory } from '../common/product-category';

@Injectable({
  providedIn: 'root'
})
export class ProductCategoryService {

  private baseUrl= "http://localhost:8080/api/productCategories/";

  constructor(private httpClient: HttpClient) { }

  getCategories(): Observable<ProductCategory[]> {
    return this.httpClient.get<GetResponse>(this.baseUrl).pipe(
      map(response => response._embedded.productCategories)
    )
  }
}

interface GetResponse {
  _embedded:{
    productCategories: ProductCategory[];
  }
}
