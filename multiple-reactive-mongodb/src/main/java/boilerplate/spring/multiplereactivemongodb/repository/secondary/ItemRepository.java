package boilerplate.spring.multiplereactivemongodb.repository.secondary;

import boilerplate.spring.multiplereactivemongodb.entity.Item;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ItemRepository extends ReactiveMongoRepository<Item, String>, ItemRepositoryCustom {
}
