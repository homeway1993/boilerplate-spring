package boilerplate.spring;

import boilerplate.spring.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class TestingRunner implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public void run(String... args) throws Exception {
        /* Writing test code here. */
    }
}
