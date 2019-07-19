package boilerplate.spring.reactivemongodb.repository;


import boilerplate.spring.reactivemongodb.entity.Person;
import reactor.core.publisher.Mono;

public interface PersonRepositoryCustom {

    Class<Person> ENTITY_CLASS = Person.class;

    Mono<Person> findFist();
}
