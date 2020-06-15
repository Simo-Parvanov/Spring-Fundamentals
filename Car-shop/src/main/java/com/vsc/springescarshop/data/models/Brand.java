package com.vsc.springescarshop.data.models;
import com.vsc.springescarshop.data.models.base.BaseEntity;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {
    private String name;

    public Brand() {
    }

    @Column(name = "name", nullable = false)
    @Length(min = 1, max = 40)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

