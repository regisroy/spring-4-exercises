package com.zenika;

import org.springframework.context.annotation.Import;

//@Configuration
@Import(value = {ServicesConfig.class, RepositoriesConfig.class})
public class ApplicationConfig {

}
