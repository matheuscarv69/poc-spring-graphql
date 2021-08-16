package compras;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class QueryGraphQL implements GraphQLQueryResolver {

    public String hello() {
        return "Hello World";
    }

    public Integer soma(Integer a, Integer b) {
        return a + b;
    }

}
