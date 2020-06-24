package com.svc.exampreparation.services.models;

import com.svc.exampreparation.date.CategoryEnum;
import com.svc.exampreparation.date.Gender;

import java.math.BigDecimal;

public class ItemCreateServiceModel {
    private String name;
    private String description;
    private BigDecimal price;
    private Gender gender;
    private CategoryServiceModel category;

    public ItemCreateServiceModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public CategoryServiceModel getCategory() {
        return category;
    }

    public void setCategory(CategoryServiceModel category) {
        this.category = category;
    }
}
