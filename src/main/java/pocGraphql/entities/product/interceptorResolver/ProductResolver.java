package pocGraphql.entities.product.interceptorResolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import pocGraphql.entities.product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductResolver implements GraphQLResolver<Product> {

    public String valueInReais(Product product) {
        return "R$ " + product.getValue().toString();
    }

}
