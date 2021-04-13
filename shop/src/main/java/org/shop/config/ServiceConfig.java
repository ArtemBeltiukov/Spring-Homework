package org.shop.config;

import org.shop.api.ProposalService;
import org.shop.api.SellerService;
import org.shop.api.impl.ProposalServiceImpl;
import org.shop.api.impl.SellerServiceImpl;
import org.shop.repository.ProposalRepository;
import org.shop.repository.map.ProposalMapRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {


    @Bean(name = "proposalService")
    public ProposalService proposalService(ProposalRepository proposalRepository) {
        return new ProposalServiceImpl(proposalRepository);
    }

    @Bean(name = "sellerService")
    public SellerService sellerService() {
        return new SellerServiceImpl();
    }
}
