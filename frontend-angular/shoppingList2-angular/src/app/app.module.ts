import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { UserListComponent } from './components/user-list/user-list.component';
import {HttpClientModule} from "@angular/common/http";
import {UserService} from "./services/user.service";
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductService } from './services/product.service';
import { ShoppingListComponent } from './components/shopping-list/shopping-list.component';
import { ShoppingListService } from './services/shopping-list.service';
import { ProductCategoryComponent } from './components/product-category/product-category.component';
import { ProductCategoryService } from './services/product-category.service';

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    ProductListComponent,
    ShoppingListComponent,
    ProductCategoryComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [
    UserService,
    ProductService,
    ShoppingListService,
    ProductCategoryService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
