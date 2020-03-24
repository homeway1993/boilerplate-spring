package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.entity.Category;

import java.util.List;

public interface ChannelCatalogItemRepositoryCustom {

    void setCategoriesById(List<Category> categories, String id);
}
