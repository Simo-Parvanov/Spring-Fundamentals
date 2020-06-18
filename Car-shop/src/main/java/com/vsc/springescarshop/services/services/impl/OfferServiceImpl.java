package com.vsc.springescarshop.services.services.impl;

import com.vsc.springescarshop.data.repositories.OfferRepository;
import com.vsc.springescarshop.services.models.OfferServiceModel;
import com.vsc.springescarshop.services.services.OfferService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {
    private final OfferRepository offerRepository;
    private final ModelMapper mapper;

    public OfferServiceImpl(OfferRepository offerRepository, ModelMapper mapper) {
        this.offerRepository = offerRepository;
        this.mapper = mapper;
    }

    @Override
    public List<OfferServiceModel> allOffers() {
        return offerRepository.findAllBy()
                .stream()
                .map(offer -> mapper.map(offer, OfferServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public OfferServiceModel createOffer(OfferServiceModel offerModel) {

        return null;
    }
}
