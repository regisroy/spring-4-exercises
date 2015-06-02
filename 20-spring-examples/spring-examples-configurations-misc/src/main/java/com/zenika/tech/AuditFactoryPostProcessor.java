package com.zenika.tech;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AuditFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        List<String> beanDefinitionNames = Arrays.asList(beanFactory.getBeanDefinitionNames());
        
        Collections.sort(beanDefinitionNames);
        
        for (String beanDefinitionName : beanDefinitionNames) {
//            if (!beanDefinitionName.contains("anagement"))
//                continue;
            System.out.println("\nbeanDefinitionName = " + beanDefinitionName);
            System.out.println("   BeanClassName            = " + beanFactory.getBeanDefinition(beanDefinitionName).getBeanClassName());
            System.out.println("   PropertyValues           = " + beanFactory.getBeanDefinition(beanDefinitionName).getPropertyValues());
        }

    }
}