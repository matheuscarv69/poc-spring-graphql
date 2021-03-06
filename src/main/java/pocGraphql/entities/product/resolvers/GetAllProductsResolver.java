package pocGraphql.entities.product.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.cache.annotation.Cacheable;
import pocGraphql.entities.product.model.Product;
import pocGraphql.entities.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductsResolver implements GraphQLQueryResolver {

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "getAllProducts")
    public List<Product> getAllProducts(int page, int size, Sort.Direction direction, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.valueOf(direction.name()), sort);

        return productRepository
                .findAll(pageable)
                .getContent();
    }

}
