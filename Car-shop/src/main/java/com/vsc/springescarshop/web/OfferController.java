package com.vsc.springescarshop.web;

import com.vsc.springescarshop.web.models.OfferModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfferController {


    @GetMapping("/offer/add")
    public String addOfferForm(){
        return "offer/offer-add.html";
    }

    @PostMapping("/offer/add")
    public String addOffer(@ModelAttribute OfferModel offerModel){
        System.out.println();
        return "offer/offer-add.html";
    }
}
