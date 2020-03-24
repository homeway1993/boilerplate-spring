package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.entity.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String>, CategoryRepositoryCustom {

    Optional<Category> findByCode(String code);
}
