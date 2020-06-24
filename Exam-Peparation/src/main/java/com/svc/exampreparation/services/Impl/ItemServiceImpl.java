package com.svc.exampreparation.services.Impl;

import com.svc.exampreparation.date.Category;
import com.svc.exampreparation.date.Item;
import com.svc.exampreparation.date.reposiroties.ItemRepository;
import com.svc.exampreparation.services.CategoryService;
import com.svc.exampreparation.services.ItemService;
import com.svc.exampreparation.services.models.ItemCreateServiceModel;
import com.svc.exampreparation.web.models.ItemCreateWebModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemRepository itemRepository;
    private final ModelMapper mapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper mapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.mapper = mapper;
        this.categoryService = categoryService;
    }

    @Override
    public void createItem(ItemCreateWebModel item) {
        ItemCreateServiceModel serviceModel = mapper.map(item, ItemCreateServiceModel.class);
//        Category category = categoryService.findCategoryByName(item.getCategory().name());
        System.out.println();
        Item newItem = mapper.map(serviceModel,Item.class);

    }
}
