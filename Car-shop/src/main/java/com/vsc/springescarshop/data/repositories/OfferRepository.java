package com.vsc.springescarshop.data.repositories;

import com.vsc.springescarshop.data.models.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, String> {
    List<Offer> findAllBy();
}
