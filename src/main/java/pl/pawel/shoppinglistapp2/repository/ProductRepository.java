package pl.pawel.shoppinglistapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import pl.pawel.shoppinglistapp2.model.Product;

@Repository
@CrossOrigin("http://localhost:4200")
public interface ProductRepository  extends JpaRepository<Product, Integer> {
}
