package pocGraphql.entities.purchase.resolvers;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import pocGraphql.config.exception.ApiErrorException;
import pocGraphql.config.exception.PurchaseNotFoundException;
import pocGraphql.entities.purchase.model.Purchase;
import pocGraphql.entities.purchase.repository.PurchaseRepository;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.Optional;

@Validated
@Component
public class DeletePurchaseResolver implements GraphQLMutationResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Transactional
    @CacheEvict(value = {"getAllPurchases", "getAllPurchasesClient", "getAllPurchasesProduct"}, allEntries = true)
    public Boolean deletePurchase(@Valid @NotNull @Positive Long id) {

        Optional<Purchase> possiblePurchase = purchaseRepository.findById(id);

        if (possiblePurchase.isPresent()) {
            purchaseRepository.delete(possiblePurchase.get());
            return true;
        }

        throw new PurchaseNotFoundException();
    }

}
