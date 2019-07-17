package boilerplate.spring.multiplereactivemongodb.repository.secondary;

import boilerplate.spring.multiplereactivemongodb.entity.Item;
import reactor.core.publisher.Mono;

public interface ItemRepositoryCustom {

    Mono<Item> findFirst();
}
