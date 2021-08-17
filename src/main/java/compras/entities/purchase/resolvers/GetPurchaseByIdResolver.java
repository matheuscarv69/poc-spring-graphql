package compras.entities.purchase.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import compras.entities.purchase.model.Purchase;
import compras.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPurchaseByIdResolver implements GraphQLQueryResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase getPurchase(Long id) {

        return purchaseRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Purchase not found"));

    }

}
