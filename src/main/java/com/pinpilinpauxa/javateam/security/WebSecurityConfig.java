package com.pinpilinpauxa.javateam.security;

import com.pinpilinpauxa.javateam.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService() {

        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http

                .authorizeRequests()
                .antMatchers("/").authenticated()
                .antMatchers("/menu").authenticated()
                .antMatchers("/pedido").authenticated()
                .antMatchers("/cliente").authenticated()
                .antMatchers("/plato").authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                //.usernameParameter("email")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutSuccessUrl("/login").permitAll();

        http.csrf().disable();



             /*   .authorizeRequests()

             .antMatchers("/").authenticated()
                .antMatchers("/menu").authenticated()
                .antMatchers("/pedido").authenticated()
                //.antMatchers("/cliente").authenticated()
             //  .antMatchers("/plato").authenticated()
                .antMatchers("/plato").hasRole("USER")
                .antMatchers("/cliente").hasRole("ADMIN")



                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .failureUrl("/login?error=true")
                    .permitAll()
                .and()
                    .logout()
                    .logoutSuccessUrl("/login").permitAll();

        http.csrf().disable();*/
            /*
                .authorizeRequests()
                .antMatchers("/plato").hasRole("ADMIN")
                .and()
                .formLogin();*/

       //Código original del main



    }
}