package boilerplate.spring.multiplereactivemongodb;

import boilerplate.spring.multiplereactivemongodb.repository.primary.PersonRepository;
import boilerplate.spring.multiplereactivemongodb.repository.secondary.ItemRepository;
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
        /* Writing test code here */
    }
}
