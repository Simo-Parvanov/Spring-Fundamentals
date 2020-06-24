package com.svc.exampreparation.web;

import com.svc.exampreparation.services.ItemService;
import com.svc.exampreparation.web.models.ItemCreateWebModel;
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
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/add")
    public String getAddForm(Model model){
        if (model.containsAttribute("item")){
            model.addAttribute(new ItemCreateWebModel());
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid @ModelAttribute("item") ItemCreateWebModel item,
                              RedirectAttributes redirectAttributes,
                              BindingResult binding){
    if (binding.hasErrors()){
        return "redirect:/item/add";
    }
    try {
        itemService.createItem(item);
        return "home";
    }catch (Exception ex){
        return "redirect/item/add";
    }
    }
}
