package com.svc.exampreparation.services.Impl;

import com.svc.exampreparation.date.Category;
import com.svc.exampreparation.date.CategoryEnum;
import com.svc.exampreparation.date.reposiroties.CategoryRepository;
import com.svc.exampreparation.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper mapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, ModelMapper mapper) {
        this.categoryRepository = categoryRepository;
        this.mapper = mapper;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0){
            Arrays.stream(CategoryEnum.values()).forEach(categoryEnum -> {
                categoryRepository.save(new Category(categoryEnum,
                        String.format("Description for %s", categoryEnum.name())));
            });
        }
    }

    @Override
    public Category findCategoryByName(CategoryEnum num) {
        return categoryRepository.findByName(num).orElse(null);
    }
}
