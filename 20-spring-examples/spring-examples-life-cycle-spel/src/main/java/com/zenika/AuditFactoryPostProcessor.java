package com.zenika;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class AuditFactoryPostProcessor implements BeanFactoryPostProcessor {

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    	System.out.println("----------------------------------------------");
    	System.out.println("-            BeanFactoryPostProcessor        -");
    	System.out.println("----------------------------------------------");

    	String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("\nbeanDefinitionName = " + beanDefinitionName);
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
            System.out.println("   BeanClassName            = " + beanDefinition.getBeanClassName());
            System.out.println("   PropertyValues           = " + beanDefinition.getPropertyValues());
            System.out.println("   description              = " + beanDefinition.getDescription());
            System.out.println("   FactoryBeanName          = " + beanDefinition.getFactoryBeanName());
            System.out.println("   FactoryMethodName        = " + beanDefinition.getFactoryMethodName());
            System.out.println("   Scope                    = " + beanDefinition.getScope());
            System.out.println("   OriginatingBeanDefinition= " + beanDefinition.getOriginatingBeanDefinition());
        }
        
    	System.out.println("----------------------------------------------");
    	System.out.println("-   Fin      BeanFactoryPostProcessor        -");
    	System.out.println("----------------------------------------------\n");
    }

}