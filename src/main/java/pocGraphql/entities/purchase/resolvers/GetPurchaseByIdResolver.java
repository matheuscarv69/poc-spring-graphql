package pocGraphql.entities.purchase.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import pocGraphql.config.exception.PurchaseNotFoundException;
import pocGraphql.entities.purchase.model.Purchase;
import pocGraphql.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetPurchaseByIdResolver implements GraphQLQueryResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public Purchase getPurchase(Long id) {

        return purchaseRepository
                .findById(id)
                .orElseThrow(PurchaseNotFoundException::new);

    }

}
