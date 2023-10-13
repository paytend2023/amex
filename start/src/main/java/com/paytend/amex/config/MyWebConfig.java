package com.paytend.amex.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Sunny
 * @create 2023/9/13 08:58
 */
@Configuration
@EnableWebMvc
public class MyWebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations("file:/Users/gudongyang/Documents/amex/start/src/main/resources/static/")
                .addResourceLocations("classpath:/static/")
                .setCacheControl(CacheControl.noStore().cachePrivate());
    }
}
