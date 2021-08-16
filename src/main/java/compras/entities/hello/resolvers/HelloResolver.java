package compras.entities.hello.resolvers;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloResolver implements GraphQLQueryResolver {

    public String hello() {
        return "Hello World";
    }

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

}
