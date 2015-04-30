package com.zenika;

import org.springframework.context.annotation.Bean;

//@Configuration
public class RepositoriesConfig {

	@Bean
	public Repository repository() {
		return new Repository();
	}

}
