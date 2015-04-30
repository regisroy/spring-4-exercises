package com.zenika.region;

import com.zenika.tech.FactoryEntities;
import org.springframework.beans.factory.FactoryBean;

public class RegionRepositoryFactoryBean implements FactoryBean<RegionRepository> {


    private FactoryEntities factoryEntities;

    public RegionRepositoryFactoryBean(FactoryEntities factoryEntities) {
        this.factoryEntities = factoryEntities;
    }

    @Override
    public RegionRepository getObject() throws Exception {
        return new RegionInMemoryRepository(factoryEntities.getRegions());
    }

    @Override
    public Class<?> getObjectType() {
        return RegionRepository.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
