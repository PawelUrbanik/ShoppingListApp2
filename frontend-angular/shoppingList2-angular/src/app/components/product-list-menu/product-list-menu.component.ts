import { Component, OnInit } from '@angular/core';
import { ProductList } from 'src/app/common/product-list';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list-menu',
  templateUrl: './product-list-menu.component.html',
  styleUrls: ['./product-list-menu.component.css']
})
export class ProductListMenuComponent implements OnInit {

  productLists!: ProductList[];

  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    this.listProductLists();
  }
  listProductLists() {
    this.productService.getProductLists().subscribe(
      data => {
        console.log(data);
        console.log('Product Lists: ' + JSON.stringify(data));
        this.productLists = data;
      }
    )
  }

}
