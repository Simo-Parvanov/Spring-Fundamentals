package com.svc.exam.services;

import com.svc.exam.web.models.ProductViewModel;

import java.util.List;

public interface ProductService {
    List<ProductViewModel> allProduct();

    void createItem(ProductViewModel product);

}
