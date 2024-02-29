package com.example.flights.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        requests -> requests
                                .anyRequest()
                                .authenticated()
                )
                .formLogin(
                        AbstractAuthenticationFilterConfigurer::permitAll
                )
                .logout(
                        logoutCustomizer -> logoutCustomizer
                                .logoutUrl("/logout")
                                .logoutSuccessUrl("/login?logout")
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.ldapAuthentication()
                .userSearchBase("ou=users")
                .userSearchFilter("(&(objectClass=person)(cn={0}))")
                .contextSource()
                .url("ldap://localhost:389/dc=flights,dc=com")
                .managerDn("cn=admin,dc=flights,dc=com")
                .managerPassword("adminPassword");
    }
}
