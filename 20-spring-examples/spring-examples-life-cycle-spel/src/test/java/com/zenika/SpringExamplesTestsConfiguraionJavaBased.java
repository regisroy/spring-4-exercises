package com.zenika;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zenika.bean.FinalBean;
import com.zenika.bean.IFinal;

/**
 * A system test that verifies the components of the RewardNetwork application work together to reward for dining
 * successfully. Uses Spring to bootstrap the application for use in a test environment.
 */
@Configuration
public class SpringExamplesTestsConfiguraionJavaBased {

	@Bean
    public IFinal factoryRepositories() {
        return new FinalBean();
    }
	
	@Bean
    public IFinal factoryRepositories2() {
        return new FinalBean();
    }


}
