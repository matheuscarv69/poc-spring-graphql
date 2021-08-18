package pocGraphql.entities.purchase.inputs;

import pocGraphql.entities.client.model.Client;
import pocGraphql.entities.product.model.Product;
import pocGraphql.entities.purchase.model.Purchase;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PurchaseInput {

    @Min(0)
    private Integer quantity;

    @NotNull
    @Positive
    private Long clientId;

    @NotNull
    @Positive
    private Long productId;

    public PurchaseInput(Integer quantity, Long clientId, Long productId) {
        this.quantity = quantity;
        this.clientId = clientId;
        this.productId = productId;
    }

    public PurchaseInput() {
    }

    public Purchase toModel(Client client, Product product) {
        return new Purchase(
                this.quantity,
                client,
                product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
