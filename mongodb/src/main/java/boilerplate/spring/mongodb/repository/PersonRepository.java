package boilerplate.spring.mongodb.repository;

import boilerplate.spring.mongodb.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String>, PersonRepositoryCustom {
}
