package com.zenika;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MaConfigSpring {

	@Bean
	public MonModifieurDeContext monModifieurDeContext() {
		return new MonModifieurDeContext();
	}
}
