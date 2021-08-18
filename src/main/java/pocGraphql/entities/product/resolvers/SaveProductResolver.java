package pocGraphql.entities.product.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.validation.annotation.Validated;
import pocGraphql.entities.product.inputs.ProductInput;
import pocGraphql.entities.product.model.Product;
import pocGraphql.entities.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Validated
@Component
public class SaveProductResolver implements GraphQLMutationResolver {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product saveProduct(@Valid ProductInput productInput){
        Product product = productInput.toModel();

        return productRepository.save(product);
    }

}
