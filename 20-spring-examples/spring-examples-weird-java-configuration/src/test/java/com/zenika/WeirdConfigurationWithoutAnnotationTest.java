package com.zenika;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class WeirdConfigurationWithoutAnnotationTest {

	/*
	 * Test : tester si il est possible de creer un bean de configuration sans annotation @Configuration
	 *
	 * ici :
	 *    - utilisation @Directement de new ApplicationContext()
	 *    - je donne directement en argument de mon applicationContext 2 beans de configuration sans @Configuration
	 * CE CAS MARCHE ==> OK
	 */
	@Test
	public void configurationJavaFileWithoutAtConfiguration_is_ok() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ServicesConfig.class,
																							RepositoriesConfig.class);
		Service service = context.getBean(Service.class);
		System.out.println("service = " + service);
		System.out.println("repository = " + context.getBean(Repository.class));

		service.run();
	}

	/*
	 * Test : tester si il est possible de creer un bean de configuration sans annotation @Configuration
	 *
	 * ici :
	 *    - - utilisation @Directement de new ApplicationContext()
	 *    - cas j'ai un bean de configuration qui importe 2 bean de configuration sans @Configuration
	 * CE CAS MARCHE AUSSI
	 */
	@Test
	public void configurationJavaFileWithoutAtConfiguration_send_exception() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);

		System.out.println("service = " + context.getBean(Service.class));
		System.out.println("repository = " + context.getBean(Repository.class));
	}
}
