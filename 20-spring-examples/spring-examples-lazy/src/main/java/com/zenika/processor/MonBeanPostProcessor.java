package com.zenika.processor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

@SuppressWarnings("StringConcatenationInsideStringBufferAppend")
public class MonBeanPostProcessor implements BeanPostProcessor {

	private StringBuilder recorder;

	public MonBeanPostProcessor(StringBuilder recorder) {
		this.recorder = recorder;
	}

	@Override
	public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
		recorder.append("BeanPostProcessor:\n");
		recorder.append("   Before Initialization o=" + o + " - s=" + s + "\n");
		return o;
	}

	@Override
	public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
		recorder.append("   After Initialization  o=" + o + " - s=" + s + "\n\n");
		return o;
	}
}
