package com.vsc.springescarshop.web;

import com.vsc.springescarshop.services.models.OfferServiceModel;
import com.vsc.springescarshop.services.services.BrandService;
import com.vsc.springescarshop.services.services.OfferService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/offer")
public class OfferController {
    private final BrandService brandService;
    private final OfferService offerService;

    public OfferController(BrandService brandService, OfferService offerService) {
        this.brandService = brandService;
        this.offerService = offerService;
    }


    @GetMapping("/add")
    public String addOfferForm(Model model){
        if (model.getAttribute("offer") == null){
            model.addAttribute("offer", new OfferServiceModel());
        }
        model.addAttribute("brands", brandService.getBrands());
        return "offer-add";
    }

    @PostMapping("/add")
    public String addOffer(@ModelAttribute("offerModel")
                                       OfferServiceModel offerModel, BindingResult result, RedirectAttributes redirectAttributes){
        if (result.hasErrors()){
            redirectAttributes.addFlashAttribute("offer", offerModel);
            return "offer-add";
        }
        try {
            offerService.createOffer(offerModel);
        }catch (Exception ex){

            return "redirect:/offer/add";
        }

        return "redirect:/offers";
    }
}
