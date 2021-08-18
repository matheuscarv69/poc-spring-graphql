package compras.config.exception;

public class ProductNotFoundException extends RuntimeException {

    public static String MESSAGE = "Product not found";

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException() {
        super(MESSAGE);
    }
}
