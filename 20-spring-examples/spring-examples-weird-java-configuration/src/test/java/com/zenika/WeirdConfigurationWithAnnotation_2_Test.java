package com.zenika;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServicesConfig.class, RepositoriesConfig.class})
public class WeirdConfigurationWithAnnotation_2_Test {

	@Autowired
	ApplicationContext context;

	/*
	 * Test : tester si il est possible de créer un bean de configuration sans annotation @Configuration
	 *
	 * ici :
	 *    - utilisation @ContextConfiguration
	 *    - je donne directement en argument de mon applicationContext 2 beans de configuration sans @Configuration
	 * CE CAS MARCHE ==> OK
	 */
	@Test
	public void configurationJavaFileWithoutAtConfiguration_is_ok() throws Exception {
		Service service = context.getBean(Service.class);
		System.out.println("service = " + service);

		assertThat(service.run()).isNotEmpty()
								 .isEqualTo("ServiceImpl.run");

		Repository repository = context.getBean(Repository.class);
		System.out.println("repository = " + repository);

		assertThat(repository.get()).isEqualTo(Integer.MAX_VALUE);
	}

}
