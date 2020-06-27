package com.svc.exam.web.models;

import com.svc.exam.data.models.CategoryEnum;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductViewModel {
    private String name;
    private String description;
    private BigDecimal price;
    private LocalDateTime neededBefore;
    private CategoryEnum category;

    public ProductViewModel() {
    }

    @Length(min = 3, max = 20, message = "Name length must be between 3 and 20 characters!")
    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Length(min = 5, message = "Description min length must be minimum 5 characters!")
    @NotNull
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @DecimalMin(value = "0", message = "Price must be a positive number!")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    @FutureOrPresent(message = "Date and Time, that cannot be in the past!")
    public LocalDateTime getLocalDateTime() {
        return neededBefore;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.neededBefore = localDateTime;
    }

    @NotNull
    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }
}
