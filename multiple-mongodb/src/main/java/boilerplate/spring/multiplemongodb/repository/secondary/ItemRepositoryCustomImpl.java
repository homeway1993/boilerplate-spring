package boilerplate.spring.multiplemongodb.repository.secondary;

import boilerplate.spring.multiplemongodb.config.MultipleMongodbConfig;
import boilerplate.spring.multiplemongodb.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

public class ItemRepositoryCustomImpl implements ItemRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.SECONDARY_TEMPLATE)
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<Item> findFirst() {
        return mongoTemplate.query(Item.class).first();
    }
}
