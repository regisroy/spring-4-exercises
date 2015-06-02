package com.zenika;

import com.zenika.service.Service;
import com.zenika.spring.AppConfigOnlyJava;
import com.zenika.spring.AppConfigWithJavaAndComponentScan;
import com.zenika.spring.AppConfigWithJavaAndImportXmlAndComponentScan;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class MixedConfigurationTest {

    @Test
    @SuppressWarnings("resource")
    public void testJavaAnnotationsXmlConfig() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigWithJavaAndImportXmlAndComponentScan.class);

        Service service = applicationContext.getBean("service", Service.class);
        StringBuilder recorder = applicationContext.getBean(StringBuilder.class);

        service.execute();

        assertThat(recorder.toString()).contains("Execution de com.zenika.service.ServiceImplTwoWithXmlConfig.execute()");
    }

    @Test
    public void testXmlJavaAnnotationsConfig() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigWithJavaAndComponentScan.class);

        Service service = applicationContext.getBean("service", Service.class);
        StringBuilder recorder = applicationContext.getBean(StringBuilder.class);

        service.execute();

        assertThat(recorder.toString()).contains("Execution de com.zenika.service.ServiceImplThreeWithAnnotationConfig.execute()");
    }

    @Test
    public void testAnnotationsXmlJavaConfig() throws Exception {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfigOnlyJava.class);

        Service service = applicationContext.getBean("service", Service.class);
        StringBuilder recorder = applicationContext.getBean(StringBuilder.class);

        service.execute();

        assertThat(recorder.toString()).contains("Execution de com.zenika.service.ServiceImplOneConfigJava.execute()");
    }
}