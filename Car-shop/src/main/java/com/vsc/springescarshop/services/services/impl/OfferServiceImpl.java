package com.vsc.springescarshop.services.services.impl;

import com.vsc.springescarshop.data.models.Offer;
import com.vsc.springescarshop.data.models.User;
import com.vsc.springescarshop.data.repositories.OfferRepository;
import com.vsc.springescarshop.services.models.OfferServiceModel;
import com.vsc.springescarshop.services.services.OfferService;
import com.vsc.springescarshop.services.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper mapper;
    private final UserService userService;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper mapper, UserService userService) {
        this.offerRepository = offerRepository;
        this.mapper = mapper;
        this.userService = userService;
    }

    @Override
    public List<OfferServiceModel> allOffers() {
        return offerRepository.findAllBy()
                .stream()
                .map(offer -> mapper.map(offer, OfferServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public OfferServiceModel createOffer(OfferServiceModel offerModel, HttpSession session) {
        if (session.getAttribute("role") == "SELLER") {
            LocalDate dateTime = LocalDate.now();
            Offer offer = mapper.map(offerModel, Offer.class);
            offer.setSeller(userService.getUserByUsername(session.getAttribute("user").toString()));
            offer.setCreated(dateTime);
            offer.setModified(dateTime);
            offerRepository.saveAndFlush(offer);
            return offerModel;
        }
        throw  new SecurityException("You do not have authorization to perform this operation!");
    }

    @Override
    public OfferServiceModel findOfferById(String id) {
        return mapper.map(offerRepository.findById(Long.parseLong(id)), OfferServiceModel.class);
    }
}
