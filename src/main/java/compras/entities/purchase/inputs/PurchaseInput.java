package compras.entities.purchase.inputs;

import compras.entities.client.model.Client;
import compras.entities.product.model.Product;
import compras.entities.purchase.model.Purchase;

public class PurchaseInput {

    private Integer quantity;
    private Long clientId;
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
