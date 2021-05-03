package com.springbootsecurity.springsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    /*
    Add @EnableWebSecurity to your Security Configuration class

	AuthenticationManager
	- Authentication Manager is what does the authentication and it is our job to configure it
	through a builder class called AuthenticationManagerBuilder
		- We access the builder by extending the spring security app class 'WebSecurityConfigurerAdapter'
		 and overriding the configure method which takes in an instance of AuthenticationManagerBuilder
		 - With the builder you can assign a user a username, password and role

		 - Spring security requires you to do password encoding
		    -  Expose a @Bean of type PasswordEncoder and return a password encoder of your choosing

	 */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Set your configuration on the object
        // This configures a user and sets their user name, password and role and saves it in memory
        // You can chain this builder with the and() method to store additional users
        auth.inMemoryAuthentication()
                .withUser("user name")
                .password("password")
                .roles("USER")
                .and()
                .withUser("second user")
                .password("password")
                .roles("USER");
    }

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        // Note this password encoder doesn't actually do any encoding
        return NoOpPasswordEncoder.getInstance();
    }


}
