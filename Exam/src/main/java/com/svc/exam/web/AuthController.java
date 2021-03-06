package com.svc.exam.web;

import com.svc.exam.services.UserService;
import com.svc.exam.services.models.UserLoginServiceModel;
import com.svc.exam.web.models.UserRegisterWebModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class AuthController {
private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        if (!model.containsAttribute("user")){
            model.addAttribute("user", new UserRegisterWebModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String postRegister(@Valid @ModelAttribute("user") UserRegisterWebModel user,
                               BindingResult binding,
                               RedirectAttributes redirectAttributes){
        System.out.println();
        if (binding.hasErrors()){
            user.setPassword(null);
            user.setConfirmPassword(null);
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", binding);
            return "redirect:/user/register";
        }
        try {
            userService.register(user);
            return "login";
        }catch (Exception ex){
            user.setPassword(null);
            user.setConfirmPassword(null);
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/user/register";
        }
    }

    @GetMapping("/login")
    public String getLogin(Model model) {
        if (!model.containsAttribute("user")){
            model.addAttribute("user", new UserLoginServiceModel());
        }
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@Valid @ModelAttribute("user") UserLoginServiceModel user,
                            BindingResult binding,
                            RedirectAttributes redirectAttributes,
                            HttpSession session) {
        if (binding.hasErrors()) {
            user.setPassword(null);
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.user", binding);
            return "redirect:/user/login";
        }
        try {
            userService.userLogin(user);
            session.setAttribute("username", user.getUsername());
            return "redirect:/";
        } catch (Exception ex) {
            user.setPassword(null);
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/user/login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/";
    }
}
