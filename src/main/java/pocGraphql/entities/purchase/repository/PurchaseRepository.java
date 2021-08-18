package pocGraphql.entities.purchase.repository;

import pocGraphql.entities.purchase.model.Purchase;
import pocGraphql.entities.purchase.model.StatusPurchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> findAllByClientId(Long id);

    List<Purchase> findAllByClientIdAndStatus(Long id, StatusPurchase statusPurchase);
}
