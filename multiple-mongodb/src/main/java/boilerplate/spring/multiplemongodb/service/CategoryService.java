package boilerplate.spring.multiplemongodb.service;

import boilerplate.spring.multiplemongodb.entity.Category;

import java.util.Optional;

public interface CategoryService {

    Optional<Category> findByCode(String code);
}
