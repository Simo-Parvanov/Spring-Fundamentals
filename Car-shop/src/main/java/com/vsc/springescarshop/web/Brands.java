package com.vsc.springescarshop.web;

import com.vsc.springescarshop.services.services.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class Brands {
    private final BrandService brandService;

    public Brands(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/all")
    public String getBrands(Model model){
        model.addAttribute("brands", brandService.getBrands());
        return "brands";
    }
}
