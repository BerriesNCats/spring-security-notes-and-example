package com.springbootsecurity.springsecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

public class SpringsecurityApplication {


	/*
	The default password is printed to the console with a username of 'user

	You can override the default username and password in the application.properties file with:
	spring.security.user.name=userName
	spring.security.user.password=userPassword
	*/

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

}
