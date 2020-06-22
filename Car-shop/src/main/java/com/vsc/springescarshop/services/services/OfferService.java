package com.vsc.springescarshop.services.services;

import com.vsc.springescarshop.services.models.OfferServiceModel;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface OfferService {
    List<OfferServiceModel> allOffers();


    OfferServiceModel createOffer(OfferServiceModel offerModel, HttpSession session);

    OfferServiceModel findOfferById(String id);

}

