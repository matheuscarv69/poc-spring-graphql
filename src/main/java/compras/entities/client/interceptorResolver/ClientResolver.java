package compras.entities.client.interceptorResolver;

import com.coxautodev.graphql.tools.GraphQLResolver;
import compras.entities.client.model.Client;
import compras.entities.purchase.model.Purchase;
import compras.entities.purchase.repository.PurchaseRepository;
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


}
