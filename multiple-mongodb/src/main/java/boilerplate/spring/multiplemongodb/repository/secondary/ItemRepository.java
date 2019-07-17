package boilerplate.spring.multiplemongodb.repository.secondary;

import boilerplate.spring.multiplemongodb.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String>, ItemRepositoryCustom {
}
