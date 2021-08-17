package compras.entities.product.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.entities.product.model.Product;
import compras.entities.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class DeleteProductResolver implements GraphQLMutationResolver {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Boolean deleteProduct(Long id) {
        Optional<Product> possibleProduct = productRepository.findById(id);

        if (possibleProduct.isPresent()) {
            productRepository.delete(possibleProduct.get());
            return true;
        }

        return false;
    }

}
