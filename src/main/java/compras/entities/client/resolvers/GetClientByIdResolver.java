package compras.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import compras.config.exception.ClientNotFoundException;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetClientByIdResolver implements GraphQLQueryResolver {

    @Autowired
    private ClientRepository clientRepository;

    public Client getClient(Long id) {

        return clientRepository
                .findById(id)
                .orElseThrow(ClientNotFoundException::new);
    }

}
