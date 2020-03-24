package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.config.MultipleMongodbConfig;
import boilerplate.spring.multiplemongodb.entity.Category;
import boilerplate.spring.multiplemongodb.entity.ChannelCatalogItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class ChannelCatalogItemRepositoryCustomImpl implements ChannelCatalogItemRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.PRIMARY_TEMPLATE)
    private MongoTemplate mongoTemplate;

    @Override
    public void setCategoriesById(List<Category> categories, String id) {
        Query query = Query.query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("categories", categories);

        mongoTemplate.updateFirst(query, update, ChannelCatalogItem.class);
    }
}
