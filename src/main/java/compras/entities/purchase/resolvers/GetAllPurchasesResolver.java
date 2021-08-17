package compras.entities.purchase.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import compras.entities.purchase.model.Purchase;
import compras.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllPurchasesResolver implements GraphQLQueryResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAllPurchases() {

        return purchaseRepository
                .findAll();

    }

}
