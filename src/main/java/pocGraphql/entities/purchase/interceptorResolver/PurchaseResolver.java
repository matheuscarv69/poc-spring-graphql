package pocGraphql.entities.purchase.interceptorResolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import pocGraphql.entities.client.model.Client;
import pocGraphql.entities.client.repository.ClientRepository;
import pocGraphql.entities.product.model.Product;
import pocGraphql.entities.product.repository.ProductRepository;
import pocGraphql.entities.purchase.model.Purchase;

@Component
public class PurchaseResolver implements GraphQLResolver<Purchase> {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Cacheable(value = "getAllPurchasesClient", key = "#purchase.client.id")
    public Client client(Purchase purchase) {
        return clientRepository.findById(purchase.getClient().getId()).orElse(null);
    }

    @Cacheable(value = "getAllPurchasesProduct", key = "#purchase.product.id")
    public Product product(Purchase purchase) {
        return productRepository.findById(purchase.getProduct().getId()).orElse(null);
    }


}
