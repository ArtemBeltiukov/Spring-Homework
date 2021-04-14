package org.shop.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class AutoLoggerBeanPostProcessor implements BeanPostProcessor {

    private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private Map<String, Class> classMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(AutoLog.class)) {
            classMap.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class beanClass = classMap.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (o, method, args) -> {
                LOGGER.info("Start " + method);
                LOGGER.info("----------------");
                Object value = method.invoke(bean, args);
                LOGGER.info("----------------");
                LOGGER.info("End " + method);

                return value;
            });
        }
        return bean;
    }
}
