package com.interview.CreditCardMgmt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/creditcards").setViewName("CreditCardsMgmt");
        registry.addViewController("/").setViewName("CreditCardsMgmt");
        registry.addViewController("/signup").setViewName("SignUp");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/home").setViewName("home");
    }
}
