package com.pinpilinpauxa.javateam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@SpringBootApplication
public class PinpilinpauxaApplication {

	public static void main(String[] args) {

		SpringApplication.run(PinpilinpauxaApplication.class, args);
	}

}