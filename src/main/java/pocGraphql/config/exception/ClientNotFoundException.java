package pocGraphql.config.exception;

public class ClientNotFoundException extends RuntimeException {

    public static final String MESSAGE = "Client not found";

    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException() {
        super(MESSAGE);
    }
}
