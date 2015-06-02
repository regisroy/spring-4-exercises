package com.zenika.pays;

import com.zenika.tech.FactoryEntities;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class PaysRepositoryFactoryBean implements FactoryBean<PaysRepository>, ApplicationContextAware {
    private FactoryEntities factoryEntities;

    public PaysRepositoryFactoryBean(FactoryEntities factoryEntities) {
        this.factoryEntities = factoryEntities;
    }

    @Override
    public PaysRepository getObject() throws Exception {
        return new PaysInMemoryRepository(factoryEntities.getFrance());
    }

    @Override
    public Class<?> getObjectType() {
        return PaysRepository.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		System.out.println(applicationContext.getClass());
		
	}
}
