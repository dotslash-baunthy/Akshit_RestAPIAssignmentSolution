package com.akshitbaunthy.restapiassignmentsolution.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.akshitbaunthy.restapiassignmentsolution.service.UserDetailsServiceImpl;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService getMyUserDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public BCryptPasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

//    Encrypt all passwords (provided in plain text using BCrypt
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getMyUserDetailsService()).passwordEncoder(getPasswordEncoder());
    }

//    Which person (based on role) has permission to access which API
//    h2-console has been ignored for security via spring boot since it has its own security
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/employee/delete/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/employee/create/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.PUT, "/employee/update/single").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.GET, "/employee/read/**").hasAnyAuthority("ADMIN", "USER")
                .antMatchers(HttpMethod.POST, "/user/create/**").hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST, "/role/create/**").hasAuthority("ADMIN")
                .anyRequest().authenticated().and().httpBasic()
                .and().cors().and().csrf().disable();
        http.headers().frameOptions().disable();
    }

}
