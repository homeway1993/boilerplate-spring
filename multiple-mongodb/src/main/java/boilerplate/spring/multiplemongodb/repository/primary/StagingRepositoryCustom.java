package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.entity.Category;

import java.util.List;
import java.util.Map;

public interface StagingRepositoryCustom {

    void setCategoriesById(Map<String, List<Category>> categories, String id);
}
