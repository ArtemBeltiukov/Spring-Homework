package org.shop;


import org.shop.config.AppConfig;
import org.shop.inject.InjectInt;
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
        InjectInt injectInt = applicationContext.getBean(InjectInt.class);
        System.out.println(injectInt.getAvg());

    }
}
