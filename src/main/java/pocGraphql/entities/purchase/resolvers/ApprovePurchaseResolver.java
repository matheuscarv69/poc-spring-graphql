package pocGraphql.entities.purchase.resolvers;


import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.validation.annotation.Validated;
import pocGraphql.config.exception.ApiErrorException;
import pocGraphql.config.exception.PurchaseNotFoundException;
import pocGraphql.entities.purchase.model.Purchase;
import pocGraphql.entities.purchase.model.StatusPurchase;
import pocGraphql.entities.purchase.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Validated
@Component
public class ApprovePurchaseResolver implements GraphQLMutationResolver {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Transactional
    public StatusPurchase approvePurchase(@Valid @NotNull @Positive Long id) {

        Purchase purchase = purchaseRepository.findById(id)
                .orElseThrow(PurchaseNotFoundException::new);

        if (purchase.isPending()) {
            purchase.setStatus(StatusPurchase.OK);

            purchaseRepository.save(purchase);

            return purchase.getStatus();
        }

        throw new ApiErrorException("This Purchase is approve already");
    }

}
