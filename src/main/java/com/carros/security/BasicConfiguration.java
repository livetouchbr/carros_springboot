package com.carros.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
//https://www.baeldung.com/spring-security-method-security
//@EnableGlobalMethodSecurity(prePostEnabled = true,
//        securedEnabled = true,
//        jsr250Enabled = true)
public class BasicConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user").password("$2a$10$j4cTpMvrvbZi3MggidCuoeFl92Ql95KWPJRmO8zcHdC6GDzBYQJ92").roles("USER")
                .and()
                .withUser("admin").password("$2a$10$AxQ/Gl22aSsFaqCVouwWheubK2NuZxPEoNN/2RP7JP8dhst4sbRdu").roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}