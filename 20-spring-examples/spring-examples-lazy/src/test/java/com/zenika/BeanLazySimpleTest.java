package com.zenika;

import com.zenika.processor.MonBeanFactoryPostProcessor;
import com.zenika.processor.MonBeanPostProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BeanLazySimpleTest {

	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	StringBuilder recorder;

	@Test
	public void test_lazy_loading_bean() throws Exception {
		recorder.append("!!!! CREATION DE L'APPLICATION CONTEXT FAIT !!!!! (dans le setup du test - par le runner JUnit SpringJUnit4ClassRunner)\n");

		recorder.append("Get bean repository...\n");
		applicationContext.getBean("repository", Repository.class);

		recorder.append("\nGet bean repository Lazy ...\n");
		applicationContext.getBean("repositoryLazy", Repository.class);

		System.out.println(recorder.toString());
	}

	@SuppressWarnings("unused")
	@Configuration
	public static class Config {

		@Bean
		public Repository repository() {
			return new RepositoryNoSql(recorder());
		}

		@Bean
		@Lazy(true)
		public Repository repositoryLazy() {
			return new RepositoryLazy(recorder());
		}

		@Bean
		public MonBeanFactoryPostProcessor monBeanFactoryPostProcessor() {
			return new MonBeanFactoryPostProcessor(recorder());
		}

		@Bean
		public MonBeanPostProcessor monBeanPostProcessor() {
			return new MonBeanPostProcessor(recorder());
		}

		@Bean
		public StringBuilder recorder() {
			return new StringBuilder();
		}
	}
}
