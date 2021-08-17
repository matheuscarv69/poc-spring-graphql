package compras.entities.purchase.model;

import compras.entities.client.model.Client;
import compras.entities.product.model.Product;

import javax.persistence.*;

@Entity
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private StatusPurchase status = StatusPurchase.PENDING;

    @ManyToOne
    private Client client;

    @ManyToOne
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
