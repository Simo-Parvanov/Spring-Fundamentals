package com.vsc.springescarshop.services.models;

import com.vsc.springescarshop.data.models.EngineType;
import com.vsc.springescarshop.data.models.Model;
import com.vsc.springescarshop.data.models.TransmissionType;

public class OfferServiceModel {
    private String imageUrl;
    private Model model;
    private int mileage;
    private Double price;
    private EngineType engine;
    private TransmissionType transmission;

    public OfferServiceModel() {
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public EngineType getEngine() {
        return engine;
    }

    public void setEngine(EngineType engine) {
        this.engine = engine;
    }

    public TransmissionType getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionType transmission) {
        this.transmission = transmission;
    }
}
