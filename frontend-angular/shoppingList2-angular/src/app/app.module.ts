import { Component, NgModule } from '@angular/core';
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
import { RouterModule, Routes } from '@angular/router';
import { ProductListMenuComponent } from './components/product-list-menu/product-list-menu.component';

const routes: Routes = [
  {path: 'list/:id', component: ProductListComponent},
  {path: 'products', component: ProductListComponent},
  {path: 'user', component: UserListComponent},
  {path: '', redirectTo: 'products', pathMatch: 'full'},
  {path: '**', redirectTo: 'products', pathMatch: 'full'}
]

@NgModule({
  declarations: [
    AppComponent,
    UserListComponent,
    ProductListComponent,
    ShoppingListComponent,
    ProductCategoryComponent,
    ProductListMenuComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
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
