package compras.config.exception;

public class ApiErrorException extends RuntimeException {

    public ApiErrorException(String message) {
        super(message);
    }

}

