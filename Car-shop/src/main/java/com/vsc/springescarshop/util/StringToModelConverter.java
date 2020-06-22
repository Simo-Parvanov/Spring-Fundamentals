package com.vsc.springescarshop.util;

import com.vsc.springescarshop.data.models.Model;
import com.vsc.springescarshop.services.services.BrandService;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToModelConverter implements Converter<String, Model> {
    private  final BrandService brandService;

    public StringToModelConverter(BrandService brandService) {
        this.brandService = brandService;
    }


    @Override
    public Model convert(String modelId) {
        if (modelId.trim().length() > 0){
            return brandService.getModelById(modelId);
        }
        return null;
    }
}
