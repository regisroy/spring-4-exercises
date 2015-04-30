package com.zenika;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class TestDefinitionDynamique {

	@Test
	public void test_definition_dynamique_par_BeanFactoryPostProcessor() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MaConfigSpring.class);

		MonBean beanByType = context.getBean(MonBean.class);
		System.out.println("1: by type : monBean = " + beanByType + " - reference:" + beanByType.reference());

		MonBean beanByName = context.getBean("dynamicBean", MonBean.class);
		System.out.println("2: by name : monBean = " + beanByName + " - reference:" + beanByName.reference());

		assertThat(beanByType).isNotSameAs(beanByName);
	}
}
