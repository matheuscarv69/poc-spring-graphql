package pocGraphql.config.exception;

public class PurchaseNotFoundException extends RuntimeException {

    private static final String MESSAGE = "Purchase not found";


    public PurchaseNotFoundException(String message) {
        super(message);
    }

    public PurchaseNotFoundException() {
        super(MESSAGE);
    }
}
