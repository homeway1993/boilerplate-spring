package boilerplate.spring.mongodb.repository;

import boilerplate.spring.mongodb.entity.PersonChangeLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PersonChangeLogRepository extends MongoRepository<PersonChangeLog, String> {

    PersonChangeLog findFirstByOrderByCreatedDateDesc();
}
