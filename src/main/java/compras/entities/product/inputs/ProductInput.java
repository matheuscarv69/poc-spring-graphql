package compras.entities.product.inputs;

import compras.entities.product.model.Product;

import java.math.BigDecimal;

public class ProductInput {

    private String name;
    private BigDecimal value;

    public ProductInput(String name, BigDecimal value) {
        this.name = name;
        this.value = value;
    }

    public ProductInput() {

    }

    public Product toModel() {
        return new Product(this.name, this.value);
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
