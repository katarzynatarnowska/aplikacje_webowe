package com.restaurant.spring;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
@EnableWebMvc

public class MvcConfig implements WebMvcConfigurer {

    public MvcConfig() {
        super();
    }


    @Override
    public void addViewControllers(final ViewControllerRegistry registry) {

        registry.addViewController("/example.html");
    }



//    @Override
//    public void addResourceHandlers(final ResourceHandlerRegistry registry){
//        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
//    }

    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {

        registry.addResourceHandler(
                "/images/**",
                "/css/**"
        ).addResourceLocations(
                "classpath:/static/images/",
                "classpath:/static/css/"
        );
    }

//    @Override
//
//    public void configureDefaultServletHandling(final DefaultServletHandlerConfigurer configurer) {
//
//        configurer.enable();
//    }
//
//    @Override
//    public void addInterceptors(final InterceptorRegistry registry) {
//
//        final LocaleChangeInterceptor localeChangeInterceptor =
//                new LocaleChangeInterceptor();
//        registry.addInterceptor(localeChangeInterceptor);
//
//    }
}
