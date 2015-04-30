package com.zenika;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.zenika.bean.BeanAir;
import com.zenika.bean.BeanFeu;
import com.zenika.bean.BeanTerre;
import com.zenika.bean.Service;

public class AbstractAOPTest {

	@Autowired
	private BeanAir beanAir;

	@Autowired
	private BeanFeu beanFeu;

	@Autowired
	private BeanTerre beanTerre;

	@Autowired
	private Service service;

	@Autowired
	private StringBuilder records;

	@Before
	public void setUp() {
		records.delete(0, records.length());
	}

	protected void checkAopBeforeAndAround() {
		beanAir.setName("Air");
		beanAir.setNameAndNumber("Air 2", 12);
		System.out.println("\n==> beanAir.number = " + beanAir.getNumber() + " toString=" + beanAir.toString() + "\n");

		beanTerre.setName("Terre");
		System.out.println("\n==> beanTerre.name = " + beanTerre.getName() + "\n");

		System.out.println("\n==> beanFeu.toString = " + beanFeu.toString() + "\n" +
	                         "    class:" + beanFeu.getClass() + "\n");

		service.setElement("First element");
		System.out.println("\n==> service.element = " + service.getElement() + "\n" +
				             "    toString=" + service.toString() + "\n" +
				             "    class:" + service.getClass() + "\n");
		
		service.setElement("First element");

		assertThat(records.toString()).isEqualTo(""
						        + "@Aspect: signature = void com.zenika.bean.BeanAir.setName(String)\n"
								+ "@Aspect: signature = BeanAir com.zenika.bean.BeanAir.setNameAndNumber(String,int)\n"
								+ "@Aspect: signature = String com.zenika.bean.BeanAir.toString()\n"
								+ "@Aspect: signature = void com.zenika.bean.BeanTerre.setName(String)\n"
								+ "@Aspect: signature = String com.zenika.bean.BeanFeu.toString()\n"
								+ "@Aspect: signature = void com.zenika.bean.Service.setElement(String)\n"
								+ "@Aspect: signature = String java.lang.Object.toString()\n"
								+ "@Aspect: signature = void com.zenika.bean.Service.setElement(String)\n"
								+ "");
	}

	protected void checkAopAround() {
		beanAir.setName("Air");
		beanAir.setNameAndNumber("Air 2", 12);

		String multiply = beanAir.multiply(5);
		System.out.println("multiply = " + multiply);

		beanTerre.setName("Terre");
		System.out.println("\n==> beanTerre.name = " + beanTerre.getName() + "\n");

		System.out.println("\n==> beanFeu.toString = " + beanFeu.toString()	+ "\n");

		service.setElement("First element");
		System.out.println("\n==> service.element = " + service.getElement() + " toString=" + service.toString() + "\n");

		assertThat(records.toString()).isEqualTo(""
								+ "@Around Begin monitoring\n"
								+ " before proceed\n"
								+ " after proceed:\n"
								+ "  result=0 - Name[Air 2] Number[12]\n"
								+ "1 - Name[Air 2] Number[12]\n"
								+ "2 - Name[Air 2] Number[12]\n"
								+ "3 - Name[Air 2] Number[12]\n"
								+ "4 - Name[Air 2] Number[12]\n"
								+ "@Around End"
								+ "");
	}
}
