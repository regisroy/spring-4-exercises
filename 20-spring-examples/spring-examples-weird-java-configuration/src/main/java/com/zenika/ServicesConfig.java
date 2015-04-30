package com.zenika;

import org.springframework.context.annotation.Bean;

//@Configuration
public class ServicesConfig {

	@Bean
	public Service service(Repository repository) {
		return new ServiceImpl(repository);
	}

}
