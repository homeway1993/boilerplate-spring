package boilerplate.spring.mongodb.repository;

import boilerplate.spring.mongodb.entity.Person;
import com.mongodb.client.ChangeStreamIterable;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.BasicMongoPersistentEntity;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

import java.util.Optional;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private MongoMappingContext mongoMappingContext;

    @Override
    public Optional<Person> findFist() {
        return mongoTemplate.query(ENTITY_CLASS).first();
    }

    @Override
    public ChangeStreamIterable<Document> watch() {
        return mongoTemplate.getCollection(this.getCollectionName()).watch();
    }

    /**
     * This method gets the collection name by entity class to avoid change collection name.
     */
    private String getCollectionName() {
        BasicMongoPersistentEntity<?> collection = mongoMappingContext.getPersistentEntity(ENTITY_CLASS);
        if (collection == null) {
            throw new AssertionError("collection is null by class: " + ENTITY_CLASS);
        }
        return collection.getCollection();
    }
}
