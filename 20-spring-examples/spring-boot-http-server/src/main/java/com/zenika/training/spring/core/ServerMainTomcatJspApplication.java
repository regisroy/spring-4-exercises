package com.zenika.training.spring.core;

import com.zenika.training.spring.core.service.Service;
import com.zenika.training.spring.core.service.ServiceBase;
import com.zenika.training.spring.core.servlet.MaServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletContextInitializer;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

@SpringBootApplication
public class ServerMainTomcatJspApplication implements ServletContextInitializer {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServerMainTomcatJspApplication.class, args);
    }

    public void onStartup(ServletContext container) throws ServletException {
        // Register and map a servlet
        ServletRegistration.Dynamic servletRegistration = container.addServlet("myServlet", new MaServlet());
        servletRegistration.setLoadOnStartup(1);
        servletRegistration.addMapping("/");
    }

    @Bean
    public Service service() {
        return new ServiceBase();
    }

}
