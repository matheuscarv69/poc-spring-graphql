package compras.entities.purchase.resolvers;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.config.exception.ClientNotFoundException;
import compras.config.exception.ProductNotFoundException;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import compras.entities.product.model.Product;
import compras.entities.product.repository.ProductRepository;
import compras.entities.purchase.inputs.PurchaseInput;
import compras.entities.purchase.model.Purchase;
import compras.entities.purchase.repository.PurchaseRepository;
import graphql.GraphQLException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SavePurchaseResolver implements GraphQLMutationResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Purchase savePurchase(PurchaseInput purchaseInput) {
        Client client = clientRepository.findById(purchaseInput.getClientId())
                .orElseThrow(ClientNotFoundException::new);

        Product product = productRepository.findById(purchaseInput.getProductId())
                .orElseThrow(ProductNotFoundException::new);

        Purchase purchase = purchaseInput.toModel(client, product);

        return purchaseRepository.save(purchase);
    }

}
