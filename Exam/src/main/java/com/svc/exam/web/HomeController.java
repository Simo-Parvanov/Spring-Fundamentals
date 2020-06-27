package com.svc.exam.web;

import com.svc.exam.services.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ProductService productService;

    public HomeController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session){
        if (session.getAttribute("username") == null){
            return "index";
        }else {
            model.addAttribute("item", productService.allProduct());
        }
        return "home";
    }
}
