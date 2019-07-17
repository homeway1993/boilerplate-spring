package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonRepository extends MongoRepository<Person, String>, PersonRepositoryCustom {
}
