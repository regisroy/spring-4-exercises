package com.zenika.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

@SuppressWarnings("StringConcatenationInsideStringBufferAppend")
public class MonBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private StringBuilder recorder;

	public MonBeanFactoryPostProcessor(StringBuilder recorder) {
		this.recorder = recorder;
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
		String[] beanDefinitionNames = configurableListableBeanFactory.getBeanDefinitionNames();

		recorder.append("Bean Definitions:\n");

		for (int i = 0; i < beanDefinitionNames.length; i++) {
			String beanDefinitionName = beanDefinitionNames[i];
			recorder.append("   > " + i + ". beanDefinition = " + beanDefinitionName + "\n");
		}

		recorder.append("\n");
	}
}
