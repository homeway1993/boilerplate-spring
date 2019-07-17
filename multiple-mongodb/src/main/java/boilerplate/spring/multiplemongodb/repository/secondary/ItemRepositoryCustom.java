package boilerplate.spring.multiplemongodb.repository.secondary;

import boilerplate.spring.multiplemongodb.entity.Item;

import java.util.Optional;

public interface ItemRepositoryCustom {

    Optional<Item> findFirst();
}
