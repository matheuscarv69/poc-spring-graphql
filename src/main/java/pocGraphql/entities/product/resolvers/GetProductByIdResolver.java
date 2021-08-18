package pocGraphql.entities.product.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import pocGraphql.config.exception.ProductNotFoundException;
import pocGraphql.entities.product.model.Product;
import pocGraphql.entities.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetProductByIdResolver implements GraphQLQueryResolver {

    @Autowired
    private ProductRepository productRepository;

    public Product getProduct(Long id){

        return productRepository
                .findById(id)
                .orElseThrow(ProductNotFoundException::new);


    }


}
