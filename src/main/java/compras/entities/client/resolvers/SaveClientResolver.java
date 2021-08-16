package compras.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.entities.client.inputs.ClientInput;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class SaveClientResolver implements GraphQLMutationResolver {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client saveClient(ClientInput clientInput) {
        Client client = clientInput.toModel();

        return clientRepository.save(client);
    }


}
