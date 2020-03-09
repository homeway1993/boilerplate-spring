package boilerplate.spring.multiplemongodb;

import boilerplate.spring.multiplemongodb.repository.secondary.InventoryRepository;
import boilerplate.spring.multiplemongodb.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestingRunner implements CommandLineRunner {

    @Autowired
    private ProductService productService;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public void run(String... args) {
        /* Writing test code at here. */
        List<String> oneHasInventory = productService.findCodeHasInventory();
        System.out.println(oneHasInventory);
    }
}
