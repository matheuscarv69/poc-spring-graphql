package compras.entities.hello.resolvers;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;

@Component
public class HelloResolver implements GraphQLQueryResolver, GraphQLMutationResolver {

    public String hello() {
        return "Hello World";
    }

    public Integer sum(Integer a, Integer b) {
        return a + b;
    }

    public String yourName(String name) {
        return "Your name is " + name;
    }

}
