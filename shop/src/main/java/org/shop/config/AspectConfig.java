package org.shop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan
@ComponentScan("org.shop")
public class AspectConfig {
    @Bean
    public LogAspect logAspect(){
        return new LogAspect();
    }
}
