package com.example.colisexam.security;
/*
import  jakarta.servlet.DispatcherType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig  {



    @Bean
    public InMemoryUserDetailsManager userDetailsService(){
        UserDetails user  = User
                .withUsername("user")
                .password("user")
                .roles("USER")
                .build();
        UserDetails admin = User
                .withUsername("admin")
                .password("admin")
                .roles("ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user,admin);
    }
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http
                .csrf(httpSecurityCsrfConfigurer -> httpSecurityCsrfConfigurer.disable())
                .authorizeRequests((authorize) ->
                        authorize
                                .requestMatchers("/colis/**").hasRole("USER")
                                .requestMatchers("/centre/**", "/habitant/**").hasRole("ADMIN")
                                .anyRequest().permitAll()
                );


        return http.build();
    }



}
*/