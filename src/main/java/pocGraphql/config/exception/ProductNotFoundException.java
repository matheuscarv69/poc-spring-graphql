package pocGraphql.config.exception;

public class ProductNotFoundException extends RuntimeException {

    public static final String MESSAGE = "Product not found";

    public ProductNotFoundException(String message) {
        super(message);
    }

    public ProductNotFoundException() {
        super(MESSAGE);
    }
}
