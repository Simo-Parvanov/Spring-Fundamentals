package com.vsc.springescarshop.services.services.impl;

import com.vsc.springescarshop.data.models.Brand;
import com.vsc.springescarshop.data.models.Model;
import com.vsc.springescarshop.data.repositories.BrandRepository;
import com.vsc.springescarshop.services.services.BrandService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {
    private final BrandRepository brandRepository;

    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @Override
    public Collection<Brand> getBrands() {
        return null;
    }

    @Override
    public Brand getBrandById(String id) {
        return null;
    }

    @Override
    public Brand createBrand(Brand post) {
        return null;
    }

    @Override
    public Brand updateBrand(Brand post) {
        return null;
    }

    @Override
    public Brand deleteBrand(String id) {
        return null;
    }

    @Override
    public long getBrandsCount() {
        return brandRepository.count();
    }

    @Override
    public List<Brand> createBrandsBatch(List<Brand> posts) {
        return null;
    }

    @Override
    public Model getModelById(String id) {
        return null;
    }
}
