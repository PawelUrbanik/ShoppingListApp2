import { Component, OnInit } from '@angular/core';
import { ProductCategory } from 'src/app/common/product-category';
import { ProductCategoryService } from 'src/app/services/product-category.service';

@Component({
  selector: 'app-product-category',
  templateUrl: './product-category.component.html',
  styleUrls: ['./product-category.component.css']
})
export class ProductCategoryComponent implements OnInit {

  productCategories!: ProductCategory[];

  constructor(private productCategoryService: ProductCategoryService) { }

  ngOnInit(): void {
    this.getGetProductCategories();
  }
  
  
  getGetProductCategories() {
  this.productCategoryService.getCategories().subscribe(
    data => {
      this.productCategories=data;
    }
  )
  }

}
