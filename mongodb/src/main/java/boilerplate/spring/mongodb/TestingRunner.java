package boilerplate.spring.mongodb;

import boilerplate.spring.mongodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestingRunner implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public void run(String... args) throws Exception {
        /* Writing test code at here. */
    }
}
