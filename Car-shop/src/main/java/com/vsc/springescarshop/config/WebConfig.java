package com.vsc.springescarshop.config;

import com.vsc.springescarshop.util.StringToModelConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    private final StringToModelConverter stringToModelConverter;

    public WebConfig(StringToModelConverter stringToModelConverter) {
        this.stringToModelConverter = stringToModelConverter;
    }

    public void addFormatters(FormatterRegistry formatterRegistry){
        formatterRegistry.addConverter(stringToModelConverter);
    }
}
