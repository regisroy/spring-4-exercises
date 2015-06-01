package com.zenika.spring;

import com.zenika.service.Service;
import com.zenika.service.ServiceImplOne;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.zenika")
public class AppConfig {


    @Bean
    public Service service() {
        return new ServiceImplOne(recorder());
    }

    @Bean
    public StringBuilder recorder() {
        return new StringBuilder();
    }

}
