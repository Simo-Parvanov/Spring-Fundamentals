package com.vsc.springescarshop.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/brands")
public class Brands {

    @GetMapping("/all")
    public String getBrands(){
        return "brands";
    }
}
