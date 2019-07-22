package boilerplate.spring.mongodb.repository;

import boilerplate.spring.mongodb.entity.Person;
import com.mongodb.client.ChangeStreamIterable;
import org.bson.Document;

import java.util.Optional;

public interface PersonRepositoryCustom {

    Class<Person> ENTITY_CLASS = Person.class;

    Optional<Person> findFist();

    ChangeStreamIterable<Document> watch();
}
