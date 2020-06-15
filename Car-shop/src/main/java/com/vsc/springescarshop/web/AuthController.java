package com.vsc.springescarshop.web;

import com.vsc.springescarshop.services.models.LoginServiceModel;
import com.vsc.springescarshop.services.models.UserRegisterServiceModel;
import com.vsc.springescarshop.services.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/register")
    public ModelAndView getRegister(@Valid @ModelAttribute("user") UserRegisterServiceModel user,
                                    BindingResult binding, ModelAndView modelAndView, RedirectAttributes redirectAttributes,
                                    HttpSession session) {
        modelAndView.addObject("user", user);
        modelAndView.setViewName("auth-register");
        return modelAndView;
    }

    @PostMapping("/register")
    public String createUser(@Valid @ModelAttribute("user") UserRegisterServiceModel user, BindingResult binding,
                             RedirectAttributes redirectAttributes, HttpSession session) {
        session.removeAttribute("errorMassage");

        if (binding.hasErrors()) {
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", binding);
            return "redirect:/auth/register";
        }
        try {
            userService.createUser(user);
            return "redirect:/auth/login";
        } catch (Exception ex) {
            session.setAttribute("errorMassage", ex.getMessage());
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/auth/register";
        }
    }

    @GetMapping("/login")
    public String getLogin(@Valid @ModelAttribute("user") LoginServiceModel user,
                           BindingResult binding, ModelAndView modelAndView, RedirectAttributes redirectAttributes,
                           HttpSession session) {
        return "/auth-login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute("user") LoginServiceModel user,
                            BindingResult binding, ModelAndView modelAndView, RedirectAttributes redirectAttributes,
                            HttpSession session) {
        if (binding.hasErrors()) {
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/auth/login";
        }
        try {
            LoginServiceModel users = userService.loginUser(user);
            modelAndView.setViewName("offers");
            session.setAttribute("user", users.getUsername());
            session.setAttribute("id", users.getId());
            session.setAttribute("role", users.getRole());
            return "/offers";
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("user", user);
            session.setAttribute("errorMassage", ex.getMessage());
            return "redirect:/auth/login";
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

}
