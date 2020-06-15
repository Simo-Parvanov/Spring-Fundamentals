package com.vsc.springescarshop.web;

import com.vsc.springescarshop.services.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    private final OfferService offerService;

    public HomeController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("offers", offerService.allOffers());
        return "offers";
    }
}
