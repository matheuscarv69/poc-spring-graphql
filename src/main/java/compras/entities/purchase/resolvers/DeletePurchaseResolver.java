package compras.entities.purchase.resolvers;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.entities.purchase.model.Purchase;
import compras.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class DeletePurchaseResolver implements GraphQLMutationResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Transactional
    public Boolean deletePurchase(Long id) {

        Optional<Purchase> possiblePurchase = purchaseRepository.findById(id);

        if (possiblePurchase.isPresent()) {
            purchaseRepository.delete(possiblePurchase.get());
            return true;
        }

        return false;
    }

}
