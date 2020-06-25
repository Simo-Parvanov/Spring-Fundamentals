package com.svc.exampreparation.services;

import com.svc.exampreparation.date.Category;
import com.svc.exampreparation.date.CategoryEnum;

public interface CategoryService {

    void initCategories();

    Category findCategoryByName(CategoryEnum num);
}
