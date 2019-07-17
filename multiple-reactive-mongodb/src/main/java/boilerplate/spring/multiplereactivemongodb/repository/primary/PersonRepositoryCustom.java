package boilerplate.spring.multiplereactivemongodb.repository.primary;

import boilerplate.spring.multiplereactivemongodb.entity.Person;
import reactor.core.publisher.Mono;

public interface PersonRepositoryCustom {

    Mono<Person> findFirst();
}
