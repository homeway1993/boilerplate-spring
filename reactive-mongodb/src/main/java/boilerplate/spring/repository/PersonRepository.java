package boilerplate.spring.repository;


import boilerplate.spring.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonRepository extends ReactiveMongoRepository<Person, String>, PersonRepositoryCustom {
}
