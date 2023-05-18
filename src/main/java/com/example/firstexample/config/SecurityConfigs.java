package com.example.firstexample.config;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfigs {
    @Bean
    DataSource dataSource() {
        return DataSourceBuilder
                .create()
                .url("jdbc:mysql://localhost:3306/lab2")
                .username("root")
                .password("root")
                .build();
    }
    @Bean
    SecurityFilterChain apiSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity
                .authorizeHttpRequests(auth ->{
                    auth.requestMatchers("/public").permitAll();
                    auth.requestMatchers("/private").hasAnyRole("ADMIN");
                }
                ).httpBasic(Customizer.withDefaults()).build();
    }
}
