package compras.config.exception;


import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GenericGraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import graphql.validation.ValidationError;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

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

            // Logar o error
            return new ExceptionResponse("Ocorreu um erro ao processar a transação.");
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