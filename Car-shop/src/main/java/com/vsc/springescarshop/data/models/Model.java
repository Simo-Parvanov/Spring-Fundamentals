package com.vsc.springescarshop.data.models;

import com.vsc.springescarshop.data.models.base.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "models")
public class Model extends BaseEntity implements Comparable<Model> {
    private String name;
    private String imageUrl;
    private Integer startYear;
    private Integer endYear;
    private Date created = new Date();
    private Date modified = new Date();
    private VehicleCategory category;
    private Brand brand;

    public Model() {
    }

    public Model(String m2, VehicleCategory car, Integer i, Integer o, String s) {
        this.name = m2;
        this.category = car;
        this.startYear = i;
        this.endYear = o;
        this.imageUrl = s;

    }

    @Column(name = "name", nullable = false)
    @Length(min = 1, max = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Column(name = "start_year", nullable = false)
    public Integer getStartYear() {
        return startYear;
    }

    public void setStartYear(Integer startYear) {
        this.startYear = startYear;
    }

    @Column(name = "end_year")
    public Integer getEndYear() {
        return endYear;
    }

    public void setEndYear(Integer endYear) {
        this.endYear = endYear;
    }

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Column(name = "modified")
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @ManyToOne
    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Column(name = "category")
    @NotNull
    @Enumerated(EnumType.STRING)
    public VehicleCategory getCategory() {
        return category;
    }

    public void setCategory(VehicleCategory category) {
        this.category = category;
    }

    @Override
    public int compareTo(Model o) {
        return name.compareToIgnoreCase(o.getName());
    }
}
