package boilerplate.spring.repository;


import boilerplate.spring.entity.Person;
import reactor.core.publisher.Mono;

public interface PersonRepositoryCustom {

    Class<Person> ENTITY_CLASS = Person.class;

    Mono<Person> findFist();
}
