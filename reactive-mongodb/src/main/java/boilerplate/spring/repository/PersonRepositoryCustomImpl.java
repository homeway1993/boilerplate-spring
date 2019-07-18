package boilerplate.spring.repository;

import boilerplate.spring.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import reactor.core.publisher.Mono;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @Autowired
    private ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Person> findFist() {
        return reactiveMongoTemplate.query(ENTITY_CLASS).first();
    }
}
