package org.shop.config;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.UserService;
import org.shop.api.impl.ProductServiceImpl;
import org.shop.api.impl.UserServiceImpl;
import org.shop.inject.InjectInt;
import org.shop.repository.map.ProductMapRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RepositoryConfig.class, DataConfig.class, FactoryConfig.class, ServiceConfig.class})
public class AppConfig {

    @Bean
    public InjectInt injectInt(){
        return new InjectInt();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean(name = "productService")
    public ProductService productService() {
        return new ProductServiceImpl(new ProductMapRepository());
    }

    @Bean
    public Logger logger() {
        return LoggerFactory.getLogger(this.getClass());
    }

    @Bean
    public AutoLoggerBeanPostProcessor autoLoggerBeanPostProcessor() {
        return new AutoLoggerBeanPostProcessor();
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        return new SellerInitializer();
    }

    @Bean
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public ProductInitializer productInitializer() {
        return new ProductInitializer(productService());
    }

    @Bean(initMethod = "initData")
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }

    @Bean
    public UserInitializer userInitializer() {
        return new UserInitializer(userService());
    }

    @Bean
    public InjectRandomIntBeanPostProcessor injectRandomIntBeanPostProcessor(){
        return new InjectRandomIntBeanPostProcessor();
    }

}
