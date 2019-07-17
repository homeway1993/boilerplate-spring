package boilerplate.spring.multiplereactivemongodb.repository.secondary;

import boilerplate.spring.multiplereactivemongodb.config.MultipleMongodbConfig;
import boilerplate.spring.multiplereactivemongodb.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Mono;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.SECONDARY_TEMPLATE)
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Item> findFirst() {
        return reactiveMongoTemplate.query(Item.class).first();
    }
}
