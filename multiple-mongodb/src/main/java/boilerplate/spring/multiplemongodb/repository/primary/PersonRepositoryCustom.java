package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.entity.Person;

import java.util.Optional;

public interface PersonRepositoryCustom {

    Optional<Person> findFirst();
}
