package boilerplate.spring.multiplemongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class MultipleMongodbApplication {

    public static void main(String[] args) {
        SpringApplication.run(MultipleMongodbApplication.class, args);
    }
}
