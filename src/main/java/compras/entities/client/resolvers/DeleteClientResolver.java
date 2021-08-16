package compras.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteClientResolver implements GraphQLMutationResolver {

    @Autowired
    private ClientRepository clientRepository;

    public Boolean deleteClient(Long id) {
        Optional<Client> client = clientRepository.findById(id);

        if (client.isPresent()) {
            clientRepository.delete(client.get());
            return true;
        }

        return false;
    }

}
