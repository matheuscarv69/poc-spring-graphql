package pocGraphql.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import pocGraphql.config.exception.ClientNotFoundException;
import pocGraphql.entities.client.inputs.ClientInput;
import pocGraphql.entities.client.model.Client;
import pocGraphql.entities.client.repository.ClientRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
@Component
public class UpdateClientResolver implements GraphQLMutationResolver {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    @CacheEvict(value = {"getAllClients", "getClientsPurchases", "getClientsPurchasesByStatus"}, allEntries = true)
    public Client updateClient(@Valid @NotNull @Positive Long id, @Valid ClientInput clientInput) {

        Client client = clientRepository.findById(id).orElseThrow(ClientNotFoundException::new);

        client.setName(clientInput.getName());
        client.setEmail(clientInput.getEmail());

        return client;
    }

}
