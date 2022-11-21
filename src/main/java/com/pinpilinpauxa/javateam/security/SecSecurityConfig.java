package com.pinpilinpauxa.javateam.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/resources/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/menu").hasAnyRole("USER", "ADMIN")
                .antMatchers("/pedido").hasAnyRole("USER", "ADMIN")
                .antMatchers("/cliente").hasAnyRole("USER", "ADMIN")
                .antMatchers("/plato").hasAnyRole("USER", "ADMIN")
                .and().formLogin().permitAll()
                .and().logout().permitAll();

        // .antMatchers("/addNewEmployee").hasAnyRole("ADMIN").anyRequest().authenticated()
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder().encode("user"))
                .authorities("ROLE_USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder().encode("admin"))
                .authorities("ROLE_USER", "ROLE_ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}