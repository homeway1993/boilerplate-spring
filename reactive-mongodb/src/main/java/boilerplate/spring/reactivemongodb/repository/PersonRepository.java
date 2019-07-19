package boilerplate.spring.reactivemongodb.repository;


import boilerplate.spring.reactivemongodb.entity.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonRepository extends ReactiveMongoRepository<Person, String>, PersonRepositoryCustom {
}
