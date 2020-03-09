package boilerplate.spring.multiplemongodb.repository.secondary;

import boilerplate.spring.multiplemongodb.entity.Cbu;
import boilerplate.spring.multiplemongodb.entity.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

public class InventoryRepositoryCustomImpl implements InventoryRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Inventory findByCbuAndDepartmentCodeAndHasQuantity(Cbu cbu, String departmentCode) {
        Criteria criteria = new Criteria();
        criteria.and("quantity").gt(0);
        criteria.and("cbu.modelSeqNbr").is(cbu.getModelSeqNbr());
        if (cbu.getInventoryId() != null) {
            criteria.and("cbu.inventoryId").is(cbu.getInventoryId());
        }
        if (cbu.getWeightRange() != null) {
            criteria.and("cbu.weightRange").is(cbu.getWeightRange());
        }

        Query query = Query.query(criteria);
        return mongoTemplate.findOne(query, Inventory.class);
    }
}
