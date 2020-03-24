package boilerplate.spring.multiplemongodb.repository.primary;

import boilerplate.spring.multiplemongodb.entity.Language;

public interface CategoryRepositoryCustom {

    void setSearchDisplayNameById(Language searchDisplayName, String id);
}
