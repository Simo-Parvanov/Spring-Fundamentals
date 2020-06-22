package com.svc.exampreparation.Date;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Positive;


//        •	Has a Category
//        o	Has a relation with Categories
//        •	Has a Gender – an option between (Male and Female)


@Entity
@Table(name = "items")
public class Item extends BaseEntity{
    private String name;
    private String description;
    private Double price;
    private Category category;
    private Gender gender;

    public Item() {
    }

    @Column(name = "name", unique = true)
    @Length(min = 2)
    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @Column(name = "price")
    @Positive
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
