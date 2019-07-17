package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.config.MultipleMongodbConfig;
import boilerplate.spring.multiplemongodb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Optional;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.PRIMARY_TEMPLATE)
    private MongoTemplate mongoTemplate;

    @Override
    public Optional<Person> findFirst() {
        return mongoTemplate.query(Person.class).first();
    }
}
