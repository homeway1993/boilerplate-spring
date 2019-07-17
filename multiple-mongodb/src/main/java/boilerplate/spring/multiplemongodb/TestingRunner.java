package boilerplate.spring.multiplemongodb;

import boilerplate.spring.multiplemongodb.repository.primary.PersonRepository;
import boilerplate.spring.multiplemongodb.repository.secondary.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestingRunner implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public void run(String... args) throws Exception {
        /* Running test code at here. */
    }
}
