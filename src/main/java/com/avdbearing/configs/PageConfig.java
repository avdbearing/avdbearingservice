package com.avdbearing.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class PageConfig implements WebMvcConfigurer {

    @Override

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/parts").setViewName("parts");
        registry.addViewController("/updatePart").setViewName("updatePart");
        registry.addViewController("/addClient").setViewName("addClient");
        registry.addViewController("/brands").setViewName("brands");
        registry.addViewController("/updateBrand").setViewName("updateBrand");


    }


}
