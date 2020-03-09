package boilerplate.spring.multiplemongodb.repository.secondary;

import boilerplate.spring.multiplemongodb.entity.Cbu;
import boilerplate.spring.multiplemongodb.entity.Inventory;

public interface InventoryRepositoryCustom {

    Inventory findByCbuAndDepartmentCodeAndHasQuantity(Cbu cbu, String departmentCode);
}
