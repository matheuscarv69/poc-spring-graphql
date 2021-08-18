package pocGraphql.entities.purchase.model;

import pocGraphql.entities.client.model.Client;
import pocGraphql.entities.product.model.Product;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    private LocalDateTime createdAt = LocalDateTime.now();

    @Enumerated(EnumType.STRING)
    private StatusPurchase status = StatusPurchase.PENDING;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;

    public Purchase(Integer quantity, Client client, Product product) {
        this.quantity = quantity;
        this.client = client;
        this.product = product;
    }

    public Purchase() {
    }

    public boolean isClientOwner(Long clientId) {
        return this.client.getId().equals(clientId);
    }

    public boolean isPending() {
        return this.status.name().equals(StatusPurchase.PENDING.name());
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public StatusPurchase getStatus() {
        return status;
    }

    public void setStatus(StatusPurchase status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
