package pocGraphql.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import pocGraphql.entities.client.inputs.ClientInput;
import pocGraphql.entities.client.model.Client;
import pocGraphql.entities.client.repository.ClientRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Validated
@Component
public class SaveClientResolver implements GraphQLMutationResolver {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client saveClient(@Valid ClientInput clientInput) {
        Client client = clientInput.toModel();

        return clientRepository.save(client);
    }


}
