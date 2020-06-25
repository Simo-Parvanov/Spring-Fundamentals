package com.svc.exampreparation.services.models;

import com.svc.exampreparation.date.CategoryEnum;

public class CategoryServiceModel {
    private String id;
    private CategoryEnum name;
    private String description;

    public CategoryServiceModel() {
    }

    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
