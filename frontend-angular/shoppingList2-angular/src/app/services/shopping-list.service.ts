import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { ShoppingList } from '../common/shopping-list';

@Injectable({
  providedIn: 'root'
})
export class ShoppingListService {

  private lists2: Observable<ShoppingList[]> | undefined;

  private url = 'http://localhost:8080/api/shoppingLists';

  constructor(private httpClient: HttpClient) { }


  getLists(): Observable<ShoppingList[]>{

    /* Sprawdzenie list
    this.lists2 = this.httpClient.get<GetResponse>(this.url).pipe(
      map(response => response._embedded.shoppingLists)
    )
    for (var index in this.lists2) {
      this.lists2.subscribe(response => console.log(response));
    }*/


    return this.httpClient.get<GetResponse>(this.url).pipe(
      map(response => response._embedded.shoppingLists)
    )
  }
}
interface GetResponse {
  _embedded:{
    shoppingLists: ShoppingList[];
  }
}
