package com.vsc.springescarshop.services.services;

import com.vsc.springescarshop.data.models.Offer;
import com.vsc.springescarshop.services.models.OfferServiceModel;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Favorites {
    private Map<Long, OfferServiceModel> favs = new ConcurrentHashMap<>();

    public void addOffer(OfferServiceModel offer){
        favs.put(offer.getId(),offer);
    }

    public OfferServiceModel getOfferById(Long id){
       return favs.get(id);
    }

    public OfferServiceModel removeOfferById(Long id){
        return favs.remove(id);
    }

    public Set<Long> getAllOffersId(){
        return favs.keySet();
    }

    public Collection<OfferServiceModel> getAllOffer(){
        return favs.values();
    }

}
