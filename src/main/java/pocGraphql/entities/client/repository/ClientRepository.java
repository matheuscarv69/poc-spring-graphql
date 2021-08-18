package pocGraphql.entities.client.repository;

import pocGraphql.entities.client.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
