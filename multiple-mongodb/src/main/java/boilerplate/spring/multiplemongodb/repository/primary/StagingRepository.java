package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.entity.Staging;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StagingRepository extends MongoRepository<Staging, String>, StagingRepositoryCustom {
}
