package com.zenika;

import com.zenika.processor.MonBeanFactoryPostProcessor;
import com.zenika.processor.MonBeanPostProcessor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SuppressWarnings("SpringJavaAutowiringInspection")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class BeanLazyMoinsSimpleTest {

	@Autowired
	ApplicationContext applicationContext;
	@Autowired
	StringBuilder recorder;

	@Test
	public void test_lazy_loading_bean() throws Exception {
		recorder.append("!!!! CREATION DE L'APPLICATION CONTEXT FAIT !!!!! (dans le setup du test - par le runner JUnit SpringJUnit4ClassRunner)\nDEBUT DU TEST....\n");

		recorder.append("Get bean service...\n");
		Service service = applicationContext.getBean("service", Service.class);

		service.whoAmI();

		System.out.println(recorder.toString());
	}

	@SuppressWarnings({"StringConcatenationInsideStringBufferAppend", "unused"})
	@Configuration
	public static class Config {

		@Bean
		public Repository repository() {
			return new RepositoryLazy(recorder());
		}

		@Bean
		public Service service() {
			return new ServiceDefault(recorder());
		}

		@Bean
		public MonBeanFactoryPostProcessor unBeanFactoryPostProcessor() {
			return new MonBeanFactoryPostProcessor(recorder());
		}

		@Bean
		public MonBeanPostProcessor unBeanPostProcessor() {
			return new MonBeanPostProcessor(recorder());
		}

		@Bean
		public StringBuilder recorder() {
			return new StringBuilder();
		}
	}
}
