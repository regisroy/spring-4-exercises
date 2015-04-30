package com.zenika;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class AuditPostProcessor implements BeanPostProcessor, BeanFactoryAware, ApplicationContextAware {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    	System.out.println("\n\n" + 
    			           "BeanPostProcessor   beanName = " + beanName + "\n" +
                           "                    beanClass= " + bean.getClass().getName() + "\n" +
                           "                    toString = " + String.valueOf(bean) 
                           );
    	
        System.out.println("BeanPostProcessor ->BEFORE   Initialization\n" +
                           "                    toString = " + String.valueOf(bean) 
                           );
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor ->AFTER   Initialization\n" +
                           "                    toString = " + String.valueOf(bean) 
                           );
        return bean;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println("ApplicationName=" + applicationContext.getApplicationName());
		
	}
}