package com.pinpilinpauxa.javateam;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Error implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry viewControllerRegistry){
        viewControllerRegistry.addViewController("/default_error").setViewName("default_error");
    }
}

