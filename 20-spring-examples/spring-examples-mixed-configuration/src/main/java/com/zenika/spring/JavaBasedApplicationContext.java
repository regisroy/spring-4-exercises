package com.zenika.spring;

import com.zenika.departement.DepartementRepository;
import com.zenika.pays.PaysRepository;
import com.zenika.region.RegionRepository;
import com.zenika.service.ManagementServiceBase;
import com.zenika.tech.AuditFactoryPostProcessor;
import com.zenika.tech.FactoryRepositories;
import com.zenika.ville.VilleRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.zenika")
public class JavaBasedApplicationContext {

    @Bean
    public FactoryRepositories factoryRepositories() {
        return new FactoryRepositories().initializeData();
    }

    @Bean
    public VilleRepository villeRepositroy() {
        return factoryRepositories().createVilleRepository();
    }

    @Bean
    public DepartementRepository departementRepositroy() {
        return factoryRepositories().createDepartementRepository();
    }

    @Bean
    public RegionRepository regionRepositroy() {
        return factoryRepositories().createRegionRepository();
    }

    @Bean
    public PaysRepository paysRepositroy() {
        return factoryRepositories().createPaysRepository();
    }

    @Bean
    public ManagementServiceBase managementService() {
        return new ManagementServiceBase();
    }

    @Bean
    public AuditFactoryPostProcessor auditFactoryPostProcessor() {
        return new AuditFactoryPostProcessor();
    }
}
