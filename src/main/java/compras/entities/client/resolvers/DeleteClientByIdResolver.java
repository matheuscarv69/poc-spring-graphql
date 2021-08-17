package compras.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

@Component
public class DeleteClientByIdResolver implements GraphQLMutationResolver {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Boolean deleteClient(Long id) {
        Optional<Client> possibleClient = clientRepository.findById(id);

        if (possibleClient.isPresent()) {
            clientRepository.delete(possibleClient.get());
            return true;
        }

        return false;
    }

}
