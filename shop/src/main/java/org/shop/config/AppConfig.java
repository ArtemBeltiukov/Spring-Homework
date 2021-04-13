package org.shop.config;

import org.shop.*;
import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.api.impl.ProductServiceImpl;
import org.shop.api.impl.ProposalServiceImpl;
import org.shop.api.impl.SellerServiceImpl;
import org.shop.api.impl.UserServiceImpl;
import org.shop.repository.ProposalRepository;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.ProductMapRepository;
import org.shop.repository.map.ProposalMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Configuration
@Import({RepositoryConfig.class, DataConfig.class, FactoryConfig.class, ServiceConfig.class})
public class AppConfig {

    @Autowired
    private UserService userService;
    @Autowired
    private ProductService productService;

    @Bean
    public AutoLoggerBeanPostProcessor autoLoggerBeanPostProcessor() {
        return new AutoLoggerBeanPostProcessor();
    }

    @Bean
    public SellerInitializer sellerInitializer() {
        SellerInitializer sellerInitializer = new SellerInitializer();
        Map<Long, String> sellerNames = new HashMap<>();
        sellerNames.put(1L, "amazon");
        sellerNames.put(2L, "samsung");
        try {
            Field field = sellerInitializer.getClass().getDeclaredField("sellerNames");
            field.setAccessible(true);
            ReflectionUtils.setField(field, sellerInitializer, sellerNames);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return sellerInitializer;
    }

    @Bean
    public ProposalInitializer proposalInitializer() {
        return new ProposalInitializer();
    }

    @Bean
    public ProductInitializer productInitializer() {
        return new ProductInitializer(productService);
    }

    @Bean(initMethod="initData")
    public DataInitializer dataInitializer() {
        return new DataInitializer();
    }

    @Bean
    public UserInitializer userInitializer(){
        return new UserInitializer(userService);
    }



}
