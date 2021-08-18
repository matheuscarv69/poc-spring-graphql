package pocGraphql.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.validation.annotation.Validated;
import pocGraphql.entities.client.model.Client;
import pocGraphql.entities.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

@Validated
@Component
public class DeleteClientByIdResolver implements GraphQLMutationResolver {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Boolean deleteClient(@Valid @NotNull @Positive Long id) {
        Optional<Client> possibleClient = clientRepository.findById(id);

        if (possibleClient.isPresent()) {
            clientRepository.delete(possibleClient.get());
            return true;
        }

        return false;
    }

}
