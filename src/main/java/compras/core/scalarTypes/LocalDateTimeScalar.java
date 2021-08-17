package compras.core.scalarTypes;

import compras.core.utils.DateUtils;
import graphql.language.StringValue;
import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class LocalDateTimeScalar extends GraphQLScalarType {

    public LocalDateTimeScalar() {
        super("LocalDateTime", "LocalDateTime type", new Coercing<LocalDateTime, String>() {

            /**
             * Serialize LocalDateTime for String
             * Using util class DateUtils
             * */
            @Override
            public String serialize(Object input) {
                if (input instanceof LocalDateTime) {
                    return DateUtils.toString((LocalDateTime) input);
                }
                throw new CoercingSerializeException("Invalid LocalDateTime: " + input);
            }

            /**
             * Convert String for LocalDateTime
             * Using util class DateUtils
             * */
            @Override
            public LocalDateTime parseValue(Object input) {
                if (input instanceof String) {
                    LocalDateTime dt = DateUtils.toLocalDateTime((String) input);
                    if (dt != null) {
                        return dt;
                    }
                }
                throw new CoercingParseValueException("Invalid LocalDateTime: " + input);
            }

            @Override
            public LocalDateTime parseLiteral(Object input) {
                if (!(input instanceof StringValue)) return null;
                String s = ((StringValue) input).getValue();
                LocalDateTime dt = DateUtils.toLocalDateTime(s);
                if (dt != null) {
                    return dt;
                }
                throw new CoercingParseLiteralException("Invalid LocalDateTime: " + input);
            }
        });
    }
}
