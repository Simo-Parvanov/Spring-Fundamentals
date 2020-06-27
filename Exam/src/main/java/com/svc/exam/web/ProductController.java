package com.svc.exam.web;

import com.svc.exam.services.ProductService;
import com.svc.exam.web.models.ProductViewModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/add")
    public String getAddForm(Model model) {
        if (model.containsAttribute("product")) {
            model.addAttribute(new ProductViewModel());
        }
        return "product-add";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid @ModelAttribute("product") ProductViewModel product,
                              RedirectAttributes redirectAttributes,
                              BindingResult binding) {
        if (binding.hasErrors()) {
            redirectAttributes.addFlashAttribute("product", product);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.product", binding);
            return "redirect:/product/add";
        }
        try {
            productService.createItem(product);
            return "home";
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("product", product);
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/product/add";
        }
    }
}
