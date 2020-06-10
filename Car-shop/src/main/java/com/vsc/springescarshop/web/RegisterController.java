package com.vsc.springescarshop.web;

import com.vsc.springescarshop.web.models.RegisterUserModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class RegisterController {

    @GetMapping("/register")
    public String getRegister(){
        return "auth/register.html";
    }

    @PostMapping("/register")
    public String createUser(@ModelAttribute RegisterUserModel registerUserModel){
        return "redirect:/home/home";
    }

    @GetMapping("login")
    public String getLogin(){
        return "auth/login.html";
    }
}
