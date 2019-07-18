package boilerplate.spring.mongodb.repository;

import boilerplate.spring.mongodb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<Person> findFist() {
        return mongoTemplate.query(ENTITY_CLASS).first();
    }
}
