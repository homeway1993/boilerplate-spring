package boilerplate.spring.multiplereactivemongodb.repository.primary;

import boilerplate.spring.multiplereactivemongodb.config.MultipleMongodbConfig;
import boilerplate.spring.multiplereactivemongodb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Mono;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @Autowired
    @Qualifier(MultipleMongodbConfig.PRIMARY_TEMPLATE)
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Person> findFirst() {
        return reactiveMongoTemplate.query(Person.class).first();
    }
}
