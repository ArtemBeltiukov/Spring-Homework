package org.shop.config;

import org.shop.data.User;
import org.shop.repository.ProductRepository;
import org.shop.repository.ProposalRepository;
import org.shop.repository.SellerRepository;
import org.shop.repository.UserRepository;
import org.shop.repository.factory.UserRepositoryFactory;
import org.shop.repository.map.OrderMapRepository;
import org.shop.repository.map.ProductMapRepository;
import org.shop.repository.map.ProposalMapRepository;
import org.shop.repository.map.SellerMapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
@ComponentScan("org.shop.repository")
@PropertySource("classpath:application.property")
public class RepositoryConfig {
    @Autowired
    private Environment env;

    @Bean
    public UserRepositoryFactory userRepositoryFactory(){
        return new UserRepositoryFactory();
    }

    @Bean
    public UserRepository userRepository() {
        return userRepositoryFactory().createUserRepository();
    }

    @Bean
    public OrderMapRepository orderMapRepository() {
        OrderMapRepository orderRepository = new OrderMapRepository();
        orderRepository.setSequence(Long.parseLong(Objects.requireNonNull(env.getProperty("initialSequence"))));
        return orderRepository;
    }

    @Bean
    public ProductRepository productRepository(){
        return new ProductMapRepository();
    }

    @Bean
    public SellerRepository sellerRepository(){
        return new SellerMapRepository();
    }

    @Bean
    public ProposalRepository proposalRepository(){
        return new ProposalMapRepository();
    }



}