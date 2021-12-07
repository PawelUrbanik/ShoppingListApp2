import { Component, OnInit } from '@angular/core';
import { ShoppingList } from 'src/app/common/shopping-list';
import { ShoppingListService } from 'src/app/services/shopping-list.service';

@Component({
  selector: 'app-shopping-list',
  templateUrl: './shopping-list.component.html',
  styleUrls: ['./shopping-list.component.css']
})
export class ShoppingListComponent implements OnInit {

   shoppingLists!: ShoppingList[];

  constructor(private shoppingListService: ShoppingListService) { }

  ngOnInit(): void {
    this.getShoppingLists();
  }
  getShoppingLists() {
    this.shoppingListService.getLists().subscribe(
      data => {
        this.shoppingLists = data;
      }
    )
  }

}
