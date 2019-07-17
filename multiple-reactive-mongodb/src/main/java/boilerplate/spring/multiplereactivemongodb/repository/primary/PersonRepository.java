package boilerplate.spring.multiplereactivemongodb.repository.primary;

import boilerplate.spring.multiplereactivemongodb.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonRepository extends ReactiveMongoRepository<Person, String>, PersonRepositoryCustom {
}
