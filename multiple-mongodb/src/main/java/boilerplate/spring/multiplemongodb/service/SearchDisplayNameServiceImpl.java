package boilerplate.spring.multiplemongodb.service;

import boilerplate.spring.multiplemongodb.entity.Category;
import boilerplate.spring.multiplemongodb.entity.ChannelCatalogItem;
import boilerplate.spring.multiplemongodb.entity.Staging;
import boilerplate.spring.multiplemongodb.repository.primary.CategoryRepository;
import boilerplate.spring.multiplemongodb.repository.primary.ChannelCatalogItemRepository;
import boilerplate.spring.multiplemongodb.repository.primary.StagingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchDisplayNameServiceImpl implements SearchDisplayNameService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private StagingRepository stagingRepository;

    @Autowired
    private ChannelCatalogItemRepository channelCatalogItemRepository;

    @Autowired
    private CategoryService categoryService;

    @Override
    public void setSearchDisplayNameToCategory() {
        List<Category> all = categoryRepository.findAll();
        for (Category category : all) {
            categoryRepository.setSearchDisplayNameById(category.getName(), category.getId());
        }
    }

    @Override
    public void setSearchDisplayNameToStaging() {
        for (Staging staging : stagingRepository.findAll()) {
            staging.getCategories().forEach((key, value) -> {
                value.forEach(category -> {
                    Optional<Category> optionalCategory = categoryService.findByCode(category.getCode());
                    if (optionalCategory.isPresent()) {
                        Category originalCategory = optionalCategory.get();
                        category.setName(originalCategory.getName());
                        category.setSearchDisplayName(originalCategory.getSearchDisplayName());
                    }
                });
            });

            stagingRepository.setCategoriesById(staging.getCategories(), staging.getId());
        }
    }

    @Override
    public void setSearchDisplayNameToChannelCatalogItem() {
        for (ChannelCatalogItem channelCatalogItem : channelCatalogItemRepository.findAll()) {
            channelCatalogItem.getCategories().forEach(category -> {
                Optional<Category> optionalCategory = categoryService.findByCode(category.getCode());
                if (optionalCategory.isPresent()) {
                    Category originalCategory = optionalCategory.get();
                    category.setName(originalCategory.getName());
                    category.setSearchDisplayName(originalCategory.getSearchDisplayName());
                }
            });

            channelCatalogItemRepository.setCategoriesById(channelCatalogItem.getCategories(), channelCatalogItem.getId());
        }
    }
}
