package pocGraphql.config.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GenericGraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import graphql.validation.ValidationError;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class GraphQLExceptionHandler implements GraphQLErrorHandler {

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getErrors).collect(Collectors.toList());
    }

    private GraphQLError getErrors(GraphQLError error) {

        if (error instanceof ExceptionWhileDataFetching) {
            ExceptionWhileDataFetching exceptionError = (ExceptionWhileDataFetching) error;

            if (exceptionError.getException() instanceof ClientNotFoundException) {
                Throwable ex = exceptionError.getException();
                String message = ex.getMessage();
                return new ExceptionResponse(message);
            }

            if (exceptionError.getException() instanceof ProductNotFoundException) {
                Throwable ex = exceptionError.getException();
                String message = ex.getMessage();
                return new ExceptionResponse(message);
            }

            if (exceptionError.getException() instanceof PurchaseNotFoundException) {
                Throwable ex = exceptionError.getException();
                String message = ex.getMessage();
                return new ExceptionResponse(message);
            }

            if (exceptionError.getException() instanceof ApiErrorException) {
                Throwable ex = exceptionError.getException();
                String message = ex.getMessage();
                return new ExceptionResponse(message);
            }

            if (exceptionError.getException() instanceof ConstraintViolationException) {
                Throwable ex = exceptionError.getException();
                String exceptionMessage = ex.getMessage();
                String message = "Error of validation";

                List<String> fieldsErrorsList = Arrays
                        .stream(exceptionMessage.split(","))
                        .collect(Collectors.toList());

                List<FieldErrorResponse> fieldErrorResponseList = fieldsErrorsList.stream().map(err -> {
                    String[] errors = err.split(":");
                    return new FieldErrorResponse(errors[0], errors[1]);
                }).collect(Collectors.toList());

                return new ExceptionValidationResponse(message, fieldErrorResponseList);
            }


            return new ExceptionResponse("Internal Server Error");
        }

        if (error instanceof ValidationError) {
            String msg = error.getMessage();
            return new ExceptionResponse(msg);
        }

        return error;
    }

}

class ExceptionResponse extends GenericGraphQLError {

    public ExceptionResponse(String message) {
        super(message);
    }

    @Override
    @JsonIgnore
    public List<Object> getPath() {
        return null;
    }

    @Override
    @JsonIgnore
    public Map<String, Object> getExtensions() {
        return null;
    }

}

class ExceptionValidationResponse extends GenericGraphQLError {

    private List<FieldErrorResponse> fieldsErrors = new ArrayList<FieldErrorResponse>();

    public ExceptionValidationResponse(String message) {
        super(message);
    }

    public ExceptionValidationResponse(String message, List<FieldErrorResponse> fieldsErrors) {
        super(message);
        this.fieldsErrors = fieldsErrors;
    }

    public void addFieldError(FieldErrorResponse filedError) {
        this.fieldsErrors.add(filedError);
    }

    public List<FieldErrorResponse> getFields() {
        return fieldsErrors;
    }

    @Override
    @JsonIgnore
    public List<Object> getPath() {
        return null;
    }

    @Override
    @JsonIgnore
    public Map<String, Object> getExtensions() {
        return null;
    }

}

class FieldErrorResponse {

    private String field;
    private String message;

    public FieldErrorResponse(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public FieldErrorResponse() {
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}