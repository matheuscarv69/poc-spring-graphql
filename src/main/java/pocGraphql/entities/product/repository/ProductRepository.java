package pocGraphql.entities.product.repository;

import pocGraphql.entities.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
