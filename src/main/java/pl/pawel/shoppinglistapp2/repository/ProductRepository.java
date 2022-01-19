package pl.pawel.shoppinglistapp2.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import pl.pawel.shoppinglistapp2.model.Product;

@Repository
@CrossOrigin(origins = "http://localhost:4200")
public interface ProductRepository  extends JpaRepository<Product, Integer> {

    Page<Product> findAllByListId(@RequestParam("id") Long id, Pageable pageable);
}
