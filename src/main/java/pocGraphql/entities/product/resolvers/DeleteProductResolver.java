package pocGraphql.entities.product.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.validation.annotation.Validated;
import pocGraphql.config.exception.ProductNotFoundException;
import pocGraphql.config.exception.PurchaseNotFoundException;
import pocGraphql.entities.product.model.Product;
import pocGraphql.entities.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

@Validated
@Component
public class DeleteProductResolver implements GraphQLMutationResolver {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Boolean deleteProduct(@Valid @NotNull @Positive Long id) {
        Optional<Product> possibleProduct = productRepository.findById(id);

        if (possibleProduct.isPresent()) {
            productRepository.delete(possibleProduct.get());
            return true;
        }

        throw new ProductNotFoundException();
    }
}
