package com.zenika.spring;

import com.zenika.service.Service;
import com.zenika.service.ServiceImplOne;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.zenika")
@ImportResource("classpath:com/zenika/spring/application-context.xml")
public class AppConfig {


    @Bean(name="service")
    public Service serviceOne() {
        return new ServiceImplOne(recorder());
    }

    @Bean
    public StringBuilder recorder() {
        return new StringBuilder();
    }

}
