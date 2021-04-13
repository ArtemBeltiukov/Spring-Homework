package org.shop.config;

import org.shop.ProposalInitializer;
import org.shop.api.ProductService;
import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.UserService;
import org.shop.api.impl.ProductServiceImpl;
import org.shop.api.impl.ProposalServiceImpl;
import org.shop.api.impl.SellerServiceImpl;
import org.shop.api.impl.UserServiceImpl;
import org.shop.repository.ProposalRepository;
import org.shop.repository.map.ProductMapRepository;
import org.shop.repository.map.ProposalMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.shop.api")
@AutoLog
public class ServiceConfig {

    @Autowired
    private ProposalRepository proposalRepository;

    @Bean(name = "proposalService")
    public ProposalService proposalService() {
        return new ProposalServiceImpl(proposalRepository);
    }

    @Bean(name = "sellerService")
    public SellerService sellerService() {
        return new SellerServiceImpl();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean(name = "productService")
    public ProductService productService() {
        return new ProductServiceImpl(new ProductMapRepository());
    }

}
