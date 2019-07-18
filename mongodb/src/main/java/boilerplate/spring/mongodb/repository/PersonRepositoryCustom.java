package boilerplate.spring.mongodb.repository;

import boilerplate.spring.mongodb.entity.Person;

import java.util.Optional;

public interface PersonRepositoryCustom {

    Class<Person> ENTITY_CLASS = Person.class;

    Optional<Person> findFist();
}
