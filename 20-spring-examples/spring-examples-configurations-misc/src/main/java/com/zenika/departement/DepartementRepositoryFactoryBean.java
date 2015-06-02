package com.zenika.departement;

import com.zenika.tech.FactoryEntities;
import org.springframework.beans.factory.FactoryBean;

public class DepartementRepositoryFactoryBean implements FactoryBean<DepartementRepository> {
    private FactoryEntities factoryEntities;

    public DepartementRepositoryFactoryBean(FactoryEntities factoryEntities) {
        this.factoryEntities = factoryEntities;
    }

    @Override
    public DepartementRepository getObject() throws Exception {
        return new DepartementInMemoryRepository(factoryEntities.getDepartements());
    }

    @Override
    public Class<?> getObjectType() {
        return DepartementRepository.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
