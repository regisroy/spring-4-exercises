package com.zenika;

import com.zenika.service.ManagementService;
import com.zenika.spring.JavaBasedApplicationContext;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ManagementServiceTest {


    public static final String EXPECTED = "pays = France\n" +
            "   region = Ile de France\n" +
            "      departement = Seine - prefecture:Paris\n" +
            "         ville = Paris\n" +
            "      departement = Seine Saint-Denis - prefecture:Saint-Denis\n" +
            "         ville = Bobiny\n" +
            "         ville = Saint-Denis\n" +
            "      departement = Val d'Oise - prefecture:Cergy\n" +
            "         ville = Cergy\n" +
            "      departement = Yvelines - prefecture:Versailles\n" +
            "         ville = Versailles\n" +
            "   region = Rhones-Alpes\n" +
            "      departement = Ain - prefecture:Bourg-en-Bresse\n" +
            "         ville = Bourg-en-Bresse\n" +
            "      departement = Isere - prefecture:Grenoble\n" +
            "         ville = Grenoble\n" +
            "";

    @Test
    @SuppressWarnings("resource")
    public void testWithBasicApplicationContextXml() throws Exception {
        AbstractApplicationContext applicationContext 
        = new ClassPathXmlApplicationContext("classpath:com/zenika/spring/applicationBasic-context.xml",
                                             "classpath:com/zenika/spring/application-context-infrastructure.xml");

        ManagementService managementService = applicationContext.getBean("managementService", ManagementService.class);
        String message = managementService.doService();

        Assertions.assertThat(message).isEqualTo(EXPECTED);
    }

    @Test
    @SuppressWarnings("resource")
    public void testWithFactoryMethodApplicationContextXml() throws Exception {
        AbstractApplicationContext applicationContext 
        = new ClassPathXmlApplicationContext("classpath:com/zenika/spring/application-context-with-factory-method.xml",
                                             "classpath:com/zenika/spring/application-context-infrastructure.xml");

        ManagementService managementService = applicationContext.getBean("managementService", ManagementService.class);
        String message = managementService.doService();

        Assertions.assertThat(message).isEqualTo(EXPECTED);
    }

    @Test
    @SuppressWarnings("resource")
    public void testWithFactoryBeanApplicationContextXml() throws Exception {
        AbstractApplicationContext applicationContext 
        = new ClassPathXmlApplicationContext("classpath:com/zenika/spring/application-context-with-FactoryBean.xml",
                                             "classpath:com/zenika/spring/application-context-infrastructure.xml");

        ManagementService managementService = applicationContext.getBean("managementService", ManagementService.class);
        String message = managementService.doService();

        Assertions.assertThat(message).isEqualTo(EXPECTED);
    }

    @Test
    @SuppressWarnings("resource")
    public void testWithNameSpacesCandPApplicationContextXml() throws Exception {
        AbstractApplicationContext applicationContext 
        = new ClassPathXmlApplicationContext("classpath:com/zenika/spring/application-context-with-namespaces-p-c.xml",
                                             "classpath:com/zenika/spring/application-context-infrastructure.xml");

        ManagementService managementService = applicationContext.getBean("managementService", ManagementService.class);
        String message = managementService.doService();

        Assertions.assertThat(message).isEqualTo(EXPECTED);
    }
    
	@Test
	@SuppressWarnings("resource")
    public void testWithJavaBasedConfiguration() throws Exception {
        AbstractApplicationContext applicationContext = new AnnotationConfigApplicationContext(JavaBasedApplicationContext.class);

        ManagementService managementService = applicationContext.getBean("managementService", ManagementService.class);
        String message = managementService.doService();

        Assertions.assertThat(message).isEqualTo(EXPECTED);
    }
}