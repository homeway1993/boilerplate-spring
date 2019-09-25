package boilerplate.spring.jpa;

import boilerplate.spring.jpa.repository.ExchangeRateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JpaApplication.class, args);
    }

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            /* Writing test code here. */
        };
    }
}
