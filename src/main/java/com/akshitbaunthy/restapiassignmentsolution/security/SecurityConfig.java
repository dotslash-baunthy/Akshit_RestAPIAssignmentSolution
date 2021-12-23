package com.akshitbaunthy.restapiassignmentsolution.security;

import com.akshitbaunthy.restapiassignmentsolution.repository.UserRepository;
import com.akshitbaunthy.restapiassignmentsolution.service.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
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

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(getMyUserDetailsService()).passwordEncoder(getPasswordEncoder());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/restapp/h2-console/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers("/restapp/employee/delete/**", "/restapp/role/**").hasRole("ADMIN")
                .antMatchers("/restapp/employee/create/**", "/restapp/employee/read/**", "/restapp/employee/update/single").hasRole("USER")
                .antMatchers("/restapp/login").hasAnyRole("ADMIN", "USER")
                .and().formLogin().permitAll()
                .and().logout().permitAll()
                .and().httpBasic().and().headers().frameOptions().disable();
    }
}
