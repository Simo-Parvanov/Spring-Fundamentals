package com.vsc.springescarshop.services.services;

import com.vsc.springescarshop.data.models.Brand;
import com.vsc.springescarshop.data.models.Model;

import java.util.Collection;
import java.util.List;

public interface BrandService {
    Collection<Brand> getBrands();
    Brand getBrandById(String id);
    Brand createBrand(Brand post);
    Brand updateBrand(Brand post);
    Brand deleteBrand(String id);
    long getBrandsCount();
    List<Brand> createBrandsBatch(List<Brand> posts);
    Model getModelById(String id);
}
