package com.vsc.springescarshop.web;

import com.vsc.springescarshop.services.models.OfferServiceModel;
import com.vsc.springescarshop.services.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {
    private final OfferService offerService;

    public HomeController(OfferService offerService) {
        this.offerService = offerService;
    }

    @GetMapping("/")
    public String getHome(Model model){
        List<OfferServiceModel> o = offerService.allOffers();
        model.addAttribute("offers", offerService.allOffers());
        return "offers";
    }
}
