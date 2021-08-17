package compras.entities.product.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.entities.product.inputs.ProductInput;
import compras.entities.product.model.Product;
import compras.entities.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SaveProductResolver implements GraphQLMutationResolver {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product saveProduct(ProductInput productInput){
        Product product = productInput.toModel();

        return productRepository.save(product);
    }

}
