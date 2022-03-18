package com.codegym.configure;

import com.codegym.dao.product.IProductDAO;
import com.codegym.dao.product.ProductDAO;
import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.codegym")
public class ApplicationConfig implements WebMvcConfigurer {

    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public IProductDAO productDAO(){
        return new ProductDAO();
    }

    @Bean
    public IProductService productService(){
        return new ProductService(productDAO());
    }
}
