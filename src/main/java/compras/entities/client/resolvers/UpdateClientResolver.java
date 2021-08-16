package compras.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.entities.client.inputs.ClientInput;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class UpdateClientResolver implements GraphQLMutationResolver {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client updateClient(Long id, ClientInput clientInput) {

        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Client not found"));

        client.setName(clientInput.getName());
        client.setEmail(clientInput.getEmail());

        return client;
    }

}
