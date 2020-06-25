package com.svc.exampreparation.date;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
   private CategoryEnum name;
   private String description;

    public Category() {
    }
    public Category(CategoryEnum name, String description) {
        this.name = name;
        this.description = description;
    }


    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    @Column(name = "description", columnDefinition = "TEXT")
    @Length(min = 3)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
