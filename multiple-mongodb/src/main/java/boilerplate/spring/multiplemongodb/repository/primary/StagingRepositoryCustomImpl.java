package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.config.MultipleMongodbConfig;
import boilerplate.spring.multiplemongodb.entity.Category;
import boilerplate.spring.multiplemongodb.entity.Staging;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;
import java.util.Map;

public class StagingRepositoryCustomImpl implements StagingRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.PRIMARY_TEMPLATE)
    private MongoTemplate mongoTemplate;

    @Override
    public void setCategoriesById(Map<String, List<Category>> categories, String id) {
        Query query = Query.query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("categories", categories);

        mongoTemplate.updateFirst(query, update, Staging.class);
    }
}
