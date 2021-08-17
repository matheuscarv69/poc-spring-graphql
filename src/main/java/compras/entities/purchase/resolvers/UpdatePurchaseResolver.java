package compras.entities.purchase.resolvers;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import compras.entities.product.model.Product;
import compras.entities.product.repository.ProductRepository;
import compras.entities.purchase.inputs.PurchaseInput;
import compras.entities.purchase.model.Purchase;
import compras.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UpdatePurchaseResolver implements GraphQLMutationResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Purchase updatePurchase(Long id, PurchaseInput purchaseInput) {
        Client client = clientRepository.findById(purchaseInput.getClientId())
                .orElseThrow(() -> new RuntimeException("Client not found"));

        Product product = productRepository.findById(purchaseInput.getProductId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));


        if(purchase.isClientOwner(purchaseInput.getClientId())){
            purchase.setQuantity(purchaseInput.getQuantity());
            purchase.setProduct(product);

            return purchaseRepository.save(purchase);
        }

        throw new RuntimeException("Client not is owner this purchase");
    }

}
