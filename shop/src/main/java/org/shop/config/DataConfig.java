package org.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataConfig {

    @Bean
    public Map<Long, String> sellerNames() {
        Map<Long, String> sellerNames = new HashMap<>();
        sellerNames.put(1L, "amazon");
        sellerNames.put(2L, "samsung");
        return sellerNames;
    }
}
