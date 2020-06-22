package com.svc.exampreparation.Date;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity{
   private CategoryEnum name;
   private String description;

    public Category() {
    }

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public CategoryEnum getName() {
        return name;
    }

    public void setName(CategoryEnum name) {
        this.name = name;
    }

    @Column(name = "description")
    @Length(min = 3)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
