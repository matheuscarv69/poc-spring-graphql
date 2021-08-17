package compras.entities.client.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import compras.entities.client.model.Client;
import compras.entities.client.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllClientsResolver implements GraphQLQueryResolver {

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAllClients(int page, int size, Sort.Direction direction, String sort) {
        Pageable pageable = PageRequest.of(page, size, Sort.Direction.valueOf(direction.name()), sort);

        return clientRepository
                .findAll(pageable)
                .getContent();
    }
}
