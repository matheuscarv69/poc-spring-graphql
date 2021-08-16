package compras.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllClientsResolver implements GraphQLQueryResolver {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
