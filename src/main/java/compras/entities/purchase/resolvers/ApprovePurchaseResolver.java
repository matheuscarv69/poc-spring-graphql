package compras.entities.purchase.resolvers;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.entities.purchase.model.Purchase;
import compras.entities.purchase.model.StatusPurchase;
import compras.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class ApprovePurchaseResolver implements GraphQLMutationResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Transactional
    public StatusPurchase approvePurchase(Long id) {

        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));


        if (purchase.isPending()) {
            purchase.setStatus(StatusPurchase.OK);

            purchaseRepository.save(purchase);

            return purchase.getStatus();
        }

        throw new RuntimeException("This Purchase is approve already");
    }

}
