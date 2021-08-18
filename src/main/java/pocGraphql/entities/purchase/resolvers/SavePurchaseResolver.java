package pocGraphql.entities.purchase.resolvers;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.validation.annotation.Validated;
import pocGraphql.config.exception.ClientNotFoundException;
import pocGraphql.config.exception.ProductNotFoundException;
import pocGraphql.entities.client.model.Client;
import pocGraphql.entities.client.repository.ClientRepository;
import pocGraphql.entities.product.model.Product;
import pocGraphql.entities.product.repository.ProductRepository;
import pocGraphql.entities.purchase.inputs.PurchaseInput;
import pocGraphql.entities.purchase.model.Purchase;
import pocGraphql.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Validated
@Component
public class SavePurchaseResolver implements GraphQLMutationResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Purchase savePurchase(@Valid PurchaseInput purchaseInput) {
        Client client = clientRepository.findById(purchaseInput.getClientId())
                .orElseThrow(ClientNotFoundException::new);

        Product product = productRepository.findById(purchaseInput.getProductId())
                .orElseThrow(ProductNotFoundException::new);

        Purchase purchase = purchaseInput.toModel(client, product);

        return purchaseRepository.save(purchase);
    }

}
