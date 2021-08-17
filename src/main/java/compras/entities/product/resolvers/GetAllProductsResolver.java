package compras.entities.product.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import compras.entities.product.model.Product;
import compras.entities.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllProductsResolver implements GraphQLQueryResolver {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

}
