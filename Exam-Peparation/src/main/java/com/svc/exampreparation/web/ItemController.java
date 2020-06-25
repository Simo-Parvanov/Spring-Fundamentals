package com.svc.exampreparation.web;

import com.svc.exampreparation.services.ItemService;
import com.svc.exampreparation.services.models.ItemCreateServiceModel;
import com.svc.exampreparation.web.models.ItemCreateWebModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/item")
public class ItemController {
    private final ItemService itemService;
    private final ModelMapper mapper;

    public ItemController(ItemService itemService, ModelMapper mapper) {
        this.itemService = itemService;
        this.mapper = mapper;
    }

    @GetMapping("/add")
    public String getAddForm(Model model) {
        if (model.containsAttribute("item")) {
            model.addAttribute(new ItemCreateWebModel());
        }
        return "add-item";
    }

    @PostMapping("/add")
    public String postAddForm(@Valid @ModelAttribute("item") ItemCreateWebModel item,
                              RedirectAttributes redirectAttributes,
                              BindingResult binding) {
        if (binding.hasErrors()) {
            redirectAttributes.addFlashAttribute("item", item);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.item", binding);
            return "redirect:/item/add";
        }
        try {
            itemService.createItem(item);
            return "home";
        } catch (Exception ex) {
            redirectAttributes.addFlashAttribute("item", item);
            redirectAttributes.addFlashAttribute("error", ex.getMessage());
            return "redirect:/item/add";
        }
    }

    @GetMapping("/detail/{id}")
    private String getDetail(@PathVariable("id") String id, Model model) {
        model.addAttribute("item", itemService.findById(id));
        return "details-item";
    }

    @GetMapping("/detail/item/delete/{id}")
    public String deleteItem(@PathVariable("id") String id) {
        itemService.deleteItem(id);
        return "redirect:/";
    }
}
