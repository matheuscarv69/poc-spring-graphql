package compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    @Autowired
    private ClientRepository clientRepository;

    public String hello() {
        return "Hello World";
    }

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public Client getClient(Long id) {
        Client client = clientRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        return client;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
