package pocGraphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PocJavaGraphqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocJavaGraphqlApplication.class, args);
    }

}
