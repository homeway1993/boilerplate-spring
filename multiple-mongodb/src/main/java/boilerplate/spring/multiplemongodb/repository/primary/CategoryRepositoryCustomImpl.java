package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.config.MultipleMongodbConfig;
import boilerplate.spring.multiplemongodb.entity.Category;
import boilerplate.spring.multiplemongodb.entity.Language;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.PRIMARY_TEMPLATE)
    private MongoTemplate mongoTemplate;

    @Override
    public void setSearchDisplayNameById(Language searchDisplayName, String id) {
        Query query = Query.query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("searchDisplayName", searchDisplayName);
        mongoTemplate.updateFirst(query, update, Category.class);
    }
}
