package com.svc.exam.services.impl;

import com.svc.exam.data.repositories.ProductRepository;
import com.svc.exam.services.ProductService;
import com.svc.exam.services.models.ProductServiceModel;
import com.svc.exam.web.models.ProductViewModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    public ProductServiceImpl(ProductRepository productRepository, ModelMapper mapper) {
        this.productRepository = productRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductViewModel> allProduct() {
        List<ProductServiceModel> model = productRepository.findAll()
                .stream()
                .map(product -> mapper.map(product, ProductServiceModel.class))
                .collect(Collectors.toList());
        return model.stream().map(prod -> mapper.map(prod, ProductViewModel.class)).collect(Collectors.toList());
    }

    @Override
    public void createItem(ProductViewModel product) {

    }
}
