import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products!: Product[];
  currentListId!: number;

  constructor(private productService: ProductService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe( ()=>{
      this.listProducts()
    });
    
  }

  private listProducts() {

    //sprawdz czy posiada id
    const hasListId: boolean = this.route.snapshot.paramMap.has('id');

    if(this.route.snapshot.paramMap.has('id'))
    {
      this.currentListId =  +this.route.snapshot.paramMap.get('id')!;
    }else{
      this.currentListId = 1;
    }
    this.productService.getProducts(this.currentListId).subscribe(
      data  => {
        this.products=data;
      }
    )
  }

}
