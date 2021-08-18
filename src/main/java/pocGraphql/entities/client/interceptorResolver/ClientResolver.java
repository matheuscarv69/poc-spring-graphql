package pocGraphql.entities.client.interceptorResolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import pocGraphql.entities.client.model.Client;
import pocGraphql.entities.purchase.model.Purchase;
import pocGraphql.entities.purchase.model.StatusPurchase;
import pocGraphql.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientResolver implements GraphQLResolver<Client> {

    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> purchases(Client client){
        return purchaseRepository.findAllByClientId(client.getId());
    }

    public List<Purchase> purchasesByStatus(Client client, StatusPurchase statusPurchase){
        return purchaseRepository.findAllByClientIdAndStatus(client.getId(), statusPurchase);
    }

}
