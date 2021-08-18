package pocGraphql.entities.product.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.validation.annotation.Validated;
import pocGraphql.config.exception.ProductNotFoundException;
import pocGraphql.entities.product.inputs.ProductInput;
import pocGraphql.entities.product.model.Product;
import pocGraphql.entities.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
@Component
public class UpdateProductResolver implements GraphQLMutationResolver {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @CacheEvict(value = {"getAllProducts"}, allEntries = true)
    public Product updateProduct(@Valid @NotNull @Positive Long id, @Valid ProductInput productInput) {

        Product product = productRepository.findById(id).orElseThrow(ProductNotFoundException::new);

        product.setName(productInput.getName());
        product.setValue(productInput.getValue());

        return product;
    }

}
