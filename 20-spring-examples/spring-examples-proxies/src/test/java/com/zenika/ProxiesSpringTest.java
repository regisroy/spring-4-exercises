package com.zenika;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static java.lang.String.valueOf;
import static org.assertj.core.api.Assertions.assertThat;

import com.zenika.bean.ConcreteClassTransactional;
import com.zenika.bean.ConcreteClassNotTransactional;
import com.zenika.bean.IServiceNotTransactional;
import com.zenika.bean.IServiceTransactional;
import com.zenika.bean.ServiceImplementationNotTransactional;
import com.zenika.bean.ServiceImplementationTransactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={ProxiesSpringTest.ProxiesSpringTestContext.class})
public class ProxiesSpringTest {

	@Autowired
	IServiceNotTransactional serviceNotTransactional;
	
	@Autowired
	IServiceTransactional serviceTransactional;
	
	@Autowired
	ConcreteClassNotTransactional concreteClassNotTransactional;
	
	@Autowired
	ConcreteClassTransactional concreteClassTransactional;
	
	@Test
    public void shouldDisplayProxyImplementation() throws Exception {
        System.out.println("\n---------------------------------");
        System.out.println("--- Classes WITHOUT interface ---");
        System.out.println("---------------------------------");
		
        System.out.println("\n  ---> concreteClassNotTransactional: " + concreteClassNotTransactional.getClass());
        assertThat(valueOf(concreteClassNotTransactional.getClass())).isEqualTo("class com.zenika.bean.ConcreteClassNotTransactional");
       
        System.out.println("\n  ---> concreteClassTransactional   : " + concreteClassTransactional.getClass());
        assertThat(valueOf(concreteClassTransactional.getClass()))
                                  .startsWith("class com.zenika.bean.ConcreteClassTransactional$$EnhancerBySpringCGLIB$$");

        
        System.out.println("\n------------------------------");
        System.out.println("--- Classes WITH interface ---");
        System.out.println("------------------------------");

        System.out.println("\n  ---> serviceNotTransactional      : " + serviceNotTransactional.getClass());
        assertThat(valueOf(serviceNotTransactional.getClass())).isEqualTo("class com.zenika.bean.ServiceImplementationNotTransactional");

		// ICI pas de PB : pas de java.lang.ClassCastException
		ServiceImplementationNotTransactional implementationNotTransactional = (ServiceImplementationNotTransactional)serviceNotTransactional;


        System.out.println("\n  ---> serviceTransactional         : " + serviceTransactional.getClass());
        assertThat(valueOf(serviceTransactional.getClass()))
                                  .startsWith("class com.sun.proxy.$Proxy");

        // !!! ATTENTION ici PB !!! java.lang.ClassCastException
        ServiceImplementationTransactional implementationTransactional = (ServiceImplementationTransactional)serviceTransactional;
	}
	
	
	
	@Configuration
	@ImportResource("classpath:com/zenika/AOPWithXml-context.xml")
	static class ProxiesSpringTestContext {

	    @Bean
	    public IServiceNotTransactional serviceNotTransactional() {
	        return new ServiceImplementationNotTransactional();
	    }
	    
	    @Bean
	    public IServiceTransactional iServiceTransactional() {
	        return new ServiceImplementationTransactional();
	    }
	    
	    @Bean
	    public ConcreteClassTransactional concreteClassTransactional() {
	        return new ConcreteClassTransactional();
	    }
	    
	    @Bean
	    public ConcreteClassNotTransactional concreteClassNotTransactional() {
	        return new ConcreteClassNotTransactional();
	    }

//	    @Bean
//	    public AuditFactoryPostProcessor auditFactoryPostProcessor() {
//	        return new AuditFactoryPostProcessor();
//	    }
	}
}
