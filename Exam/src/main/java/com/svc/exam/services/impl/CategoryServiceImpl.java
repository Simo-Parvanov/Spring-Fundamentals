package com.svc.exam.services.impl;

import com.svc.exam.data.models.Category;
import com.svc.exam.data.models.CategoryEnum;
import com.svc.exam.data.repositories.CategoryRepository;
import com.svc.exam.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0){
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                categoryRepository.save(new Category(categoryEnum,
                        String.format("Description for %s", categoryEnum.name())));
            });
        }
    }
}
