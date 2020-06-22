package com.vsc.springescarshop.services.models;

import com.vsc.springescarshop.data.models.EngineType;
import com.vsc.springescarshop.data.models.Model;
import com.vsc.springescarshop.data.models.TransmissionType;
import com.vsc.springescarshop.data.models.VehicleCategory;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class OfferServiceModel {
    private String imageUrl;
    private Model model;
    private int mileage;
    private Double price;
    private int year;
    private String description;
    private EngineType engine;
    private TransmissionType transmission;
    private VehicleCategory vehicleCategory;
    private LocalDate created;
    private Long id;

    public OfferServiceModel() {
    }

    @NotNull(message = "Vehicle imageUrl is required.")
    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @NotNull(message = "Vehicle model is required.")
    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @NotNull(message = "Vehicle mileage in km is required.")
    @Positive
    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @NotNull(message = "Vehicle price is required.")
    @Positive
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @NotNull(message = "Vehicle engine type is required.")
    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    @NotNull(message = "Vehicle transmission type is required.")
    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }

    @NotNull(message = "Vehicle category is required.")
    public VehicleCategory getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleCategory vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    @NotNull(message = "Vehicle  year is required.")
    @Min(1900)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Length(min = 0, max = 512)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
