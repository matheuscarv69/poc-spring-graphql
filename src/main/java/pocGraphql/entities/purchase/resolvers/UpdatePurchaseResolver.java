package pocGraphql.entities.purchase.resolvers;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.validation.annotation.Validated;
import pocGraphql.config.exception.ApiErrorException;
import pocGraphql.config.exception.ClientNotFoundException;
import pocGraphql.config.exception.ProductNotFoundException;
import pocGraphql.config.exception.PurchaseNotFoundException;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
@Component
public class UpdatePurchaseResolver implements GraphQLMutationResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    @CacheEvict(value = {"getAllPurchases", "getAllPurchasesClient", "getAllPurchasesProduct"}, allEntries = true)
    public Purchase updatePurchase(@Valid @NotNull @Positive Long id, @Valid PurchaseInput purchaseInput) {
        Client client = clientRepository.findById(purchaseInput.getClientId())
                .orElseThrow(ClientNotFoundException::new);

        Product product = productRepository.findById(purchaseInput.getProductId())
                .orElseThrow(ProductNotFoundException::new);

        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(PurchaseNotFoundException::new);

        if (purchase.isClientOwner(purchaseInput.getClientId())) {
            purchase.setQuantity(purchaseInput.getQuantity());
            purchase.setProduct(product);

            return purchaseRepository.save(purchase);
        }

        throw new ApiErrorException("Client not is owner this purchase");
    }

}
