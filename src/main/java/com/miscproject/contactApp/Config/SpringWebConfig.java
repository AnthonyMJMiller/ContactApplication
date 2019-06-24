//package com.miscproject.contactApp.Config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//import org.springframework.web.servlet.view.JstlView;
//
//@Configuration
//@ComponentScan(basePackages = {"com.miscproject"})
//@EnableWebMvc
//public class SpringWebConfig {
//	
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
//    }
//    
//    @Bean
//    public ViewResolver viewResolver(){
//        InternalResourceViewResolver vr = new InternalResourceViewResolver();
//        vr.setViewClass(JstlView.class);
//        vr.setPrefix("/WEB-INF/views/");
//        vr.setSuffix(".jsp");
//        return vr;
//    } 
//
//}
