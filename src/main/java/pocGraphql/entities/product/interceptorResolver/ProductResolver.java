package pocGraphql.entities.product.interceptorResolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.stereotype.Component;
import pocGraphql.entities.product.model.Product;

@Component
public class ProductResolver implements GraphQLResolver<Product> {

    public String valueInReais(Product product) {
        return "R$ " + product.getValue().toString();
    }

}
