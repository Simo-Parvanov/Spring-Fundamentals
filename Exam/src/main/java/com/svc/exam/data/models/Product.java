package com.svc.exam.data.models;
//
//•	Has an Id – UUID-string or Long
//        •	Has a Name (unique)
//        o	Name length must be between 3 and 20 characters (inclusive 3 and 20).
//        •	Has a Description
//        o	Description min length must be minimum 5(inclusive) characters
//        •	Has a Price
//        o	Price must be a positive number
//        •	Has a Needed Before
//        o	Date and Time, that cannot be in the past
//        •	Has a Category
//        o	Category cannot be null.

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime localDateTime;
    private Category category;

    public Product() {
    }

    @Column(name = "name", unique = true, nullable = false)
    @Length(min = 3, max = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description", unique = true, nullable = false)
    @Length(min = 5)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    @DecimalMin(value = "0")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(name = "date")
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
