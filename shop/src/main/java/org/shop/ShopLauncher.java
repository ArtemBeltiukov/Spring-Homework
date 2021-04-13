package org.shop;


import org.shop.config.AppConfig;
import org.shop.inject.InjectInt;
import org.shop.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * The ShopLauncher class.
 */
public class ShopLauncher {
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserRepository userRepository = applicationContext.getBean(UserRepository.class);
        userRepository.getUsers();
        InjectInt injectInt = applicationContext.getBean(InjectInt.class);
        System.out.println(injectInt.getAvg());
    }
}
