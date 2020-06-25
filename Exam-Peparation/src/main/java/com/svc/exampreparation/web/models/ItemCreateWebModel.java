package com.svc.exampreparation.web.models;

import com.svc.exampreparation.date.Category;
import com.svc.exampreparation.date.CategoryEnum;
import com.svc.exampreparation.date.Gender;
import com.svc.exampreparation.services.models.CategoryServiceModel;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemCreateWebModel {
    private String name;
    private String description;
    private BigDecimal price;
    private CategoryEnum category;
    private String gender;

    public ItemCreateWebModel() {
    }

    @NotNull(message = "Incorrect name!")
    @Size(min = 2,message = "The name must contain at least two characters!")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @NotNull(message = "Incorrect description!")
    @Size(min = 2,message = "The description must contain at least three characters!")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @NotNull(message = "Incorrect price!")
    @DecimalMin(value = "0", message = "Please enter a positive amount!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
