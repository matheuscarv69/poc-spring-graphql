package compras.entities.purchase.interceptorResolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import compras.entities.product.model.Product;
import compras.entities.product.repository.ProductRepository;
import compras.entities.purchase.model.Purchase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PurchaseResolver implements GraphQLResolver<Purchase>{

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public Client client(Purchase purchase){
        return clientRepository.findById(purchase.getClient().getId()).orElse(null);
    }

    public Product product(Purchase purchase){
        return productRepository.findById(purchase.getProduct().getId()).orElse(null);
    }


}
