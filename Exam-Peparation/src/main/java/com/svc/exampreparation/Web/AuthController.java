package com.svc.exampreparation.Web;

import com.svc.exampreparation.Services.Models.UserLoginServiceModel;
import com.svc.exampreparation.Services.Models.UserRegisterServiceModel;
import com.svc.exampreparation.Services.UserService;
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
            return "home";
        } catch (Exception ex) {
            user.setPassword(null);
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/user/login";
        }
    }

    @GetMapping("/register")
    public String getRegister(Model model){
        model.addAttribute("user", new UserRegisterServiceModel());
        return "register";
    }
}
