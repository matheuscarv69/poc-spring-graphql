package compras.entities.purchase.repository;

import compras.entities.purchase.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findAllByClientId(Long id);

}
