package boilerplate.spring.multiplemongodb.service;

import boilerplate.spring.multiplemongodb.entity.Category;
import boilerplate.spring.multiplemongodb.repository.primary.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Cacheable(cacheNames = "CategoryServiceImpl#findByCode")
    public Optional<Category> findByCode(String code) {
        return categoryRepository.findByCode(code);
    }
}
