package pl.pawel.shoppinglistapp2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pawel.shoppinglistapp2.model.User;

@Repository
public interface UsetRepository extends JpaRepository<User, Integer> {
}
