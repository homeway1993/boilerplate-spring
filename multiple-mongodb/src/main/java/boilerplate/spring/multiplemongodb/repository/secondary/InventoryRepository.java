package boilerplate.spring.multiplemongodb.repository.secondary;

import boilerplate.spring.multiplemongodb.entity.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface InventoryRepository extends MongoRepository<Inventory, String>, InventoryRepositoryCustom {

    @Query("{ 'quantity': { $gt: 0 }, 'departmentCode': ?0 }")
    List<Inventory> findHasQuantityByDepartmentCode(String departmentCode);
}
