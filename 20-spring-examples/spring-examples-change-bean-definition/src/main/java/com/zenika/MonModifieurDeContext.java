package com.zenika;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;

public class MonModifieurDeContext implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
		BeanDefinitionRegistry registry = ((BeanDefinitionRegistry) factory);

		GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
		beanDefinition.setBeanClass(MonBean.class);
		beanDefinition.setLazyInit(false);
		beanDefinition.setAbstract(false);
		beanDefinition.setAutowireCandidate(true);
		beanDefinition.setScope("prototype");

		registry.registerBeanDefinition("dynamicBean", beanDefinition);
	}

}