package com.svc.exampreparation.web;

import com.svc.exampreparation.services.ItemService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    private final ItemService itemService;

    public HomeController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session){
        if (session.getAttribute("username") == null){
            return "index";
        }else {
            model.addAttribute("item", itemService.allItem());
        }
        return "home";
    }
}
