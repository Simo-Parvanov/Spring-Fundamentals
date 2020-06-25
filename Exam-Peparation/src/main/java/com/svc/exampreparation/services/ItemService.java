package com.svc.exampreparation.services;

import com.svc.exampreparation.services.models.ItemCreateServiceModel;
import com.svc.exampreparation.view.ItemViewModel;
import com.svc.exampreparation.web.models.ItemCreateWebModel;

import java.util.List;

public interface ItemService {
    void createItem(ItemCreateWebModel item);

    List<ItemViewModel> allItem();

    ItemViewModel findById(String id);

    void deleteItem(String id);

}

