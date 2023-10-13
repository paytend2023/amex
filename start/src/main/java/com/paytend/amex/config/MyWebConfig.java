package com.paytend.amex.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author Sunny
 * @create 2023/9/13 08:58
 */
@Configuration
@EnableWebMvc
@Slf4j
public class MyWebConfig implements WebMvcConfigurer {

    @Resource
    ThymeleafViewResolver thymeleafViewResolver;

    @Value("${web.contextPah}")
    private String contextPath;


    @PostConstruct
    public void init() {
        log.info("init web contextPath ->>[ {} ]<<-", contextPath);
        thymeleafViewResolver.addStaticVariable("CONTEXT_PATH", contextPath);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("file:/Users/gudongyang/Documents/amex/start/src/main/resources/static/")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.noStore().cachePrivate());
    }
}
