package com.vsc.springescarshop.web;

import com.vsc.springescarshop.data.models.Offer;
import com.vsc.springescarshop.services.models.OfferServiceModel;
import com.vsc.springescarshop.services.services.BrandService;
import com.vsc.springescarshop.services.services.Favorites;
import com.vsc.springescarshop.services.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private final BrandService brandService;
    private final OfferService offerService;
    private final Favorites favorites;

    public OfferController(BrandService brandService, OfferService offerService, Favorites favorites) {
        this.brandService = brandService;
        this.offerService = offerService;
        this.favorites = favorites;
    }


    @GetMapping("/add")
    public String addOfferForm(@Valid Model model){
        if (model.getAttribute("offer") == null){
            model.addAttribute("offer", new OfferServiceModel());
        }
        model.addAttribute("brands", brandService.getBrands());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@Valid @ModelAttribute("offerModel") OfferServiceModel offerModel,
                           BindingResult binding,
                           RedirectAttributes redirectAttributes,
                           HttpSession session){
        if (binding.hasErrors()){
            redirectAttributes.addFlashAttribute("offer", offerModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.offer", binding);
            return "redirect:/offer/add";
        }
        try {
            offerService.createOffer(offerModel, session);
            return "redirect:/";
        }catch (Exception ex){
            redirectAttributes.addFlashAttribute("errors", ex.getMessage());
            return "redirect:/offer/add";
        }
    }
    @GetMapping("/details/{id}")
    public String getDetails(@PathVariable("id") String id, Model model, HttpSession session){
        model.addAttribute("offer", offerService.findOfferById(id));
        return "offer-details";
    }

    @GetMapping("/favs")
    public String getFavorites(Model model){
        model.addAttribute("favs", favorites.getAllOffer());
        return "favs";
    }

    @GetMapping("/favs/add/{id}")
    public String addFavorites(@PathVariable Long id, Model model){
        OfferServiceModel offer = offerService.findOfferById(id.toString());
        favorites.addOffer(offer);
        model.addAttribute("offer", offer);
        return "offer-details";
    }

    @GetMapping("/favs/remove/{id}")
    public String removeFavorites(@PathVariable("id") Long id, Model model){
        favorites.removeOfferById(id);
        model.addAttribute("favs", favorites.getAllOffer());
        return "favs";
    }
}
