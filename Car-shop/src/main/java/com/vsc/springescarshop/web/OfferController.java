package com.vsc.springescarshop.web;

import com.vsc.springescarshop.web.models.OfferModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/offer")
public class OfferController {


    @GetMapping("/add")
    public String addOfferForm(){
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@ModelAttribute OfferModel offerModel){
        System.out.println();
        return "offer-add";
    }
}
