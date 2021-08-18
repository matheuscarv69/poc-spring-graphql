package compras.config.exception;

public class ClientNotFoundException extends RuntimeException {

    public static String MESSAGE = "Client not found";

    public ClientNotFoundException(String message) {
        super(message);
    }

    public ClientNotFoundException() {
        super(MESSAGE);
    }
}
