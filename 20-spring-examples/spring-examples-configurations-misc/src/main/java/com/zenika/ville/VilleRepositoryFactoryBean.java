package com.zenika.ville;

import com.zenika.tech.FactoryEntities;
import org.springframework.beans.factory.FactoryBean;

public class VilleRepositoryFactoryBean implements FactoryBean<VilleRepository> {
    private FactoryEntities factoryEntities;

    public VilleRepositoryFactoryBean(FactoryEntities factoryEntities) {
        this.factoryEntities = factoryEntities;
    }

    @Override
    public VilleRepository getObject() throws Exception {
        return new VilleInMemoryRepository(factoryEntities.getVilles());
    }

    @Override
    public Class<?> getObjectType() {
        return VilleRepository.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
