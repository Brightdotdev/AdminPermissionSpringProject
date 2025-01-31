package com.example.AdminPermission;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class Config {
    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    //method to generate a hashedpassword
    private PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable()).authorizeHttpRequests((authorize)
                        -> authorize
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/auth/**  ").permitAll()

                        .requestMatchers("/api/items/**").hasAnyRole("USER", "ADMIN") // All users can read items
                        .requestMatchers("/api/users/**").hasAnyRole("ADMIN", "USER")
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Only admins can access admin routes


                        .requestMatchers("/user/**").authenticated()
                        .requestMatchers("/api/**").authenticated()
                        .requestMatchers("/user/**").hasRole("USER") // Only authenticated users can access

                        .requestMatchers(HttpMethod.POST, "/api/items/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT, "/api/items/**").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/api/items/**").hasRole("ADMIN")// Users wont have access to the create, update and delete method

                       .anyRequest().authenticated()
                )
                .formLogin(form -> form.loginPage("/auth/login")
                        .permitAll()
                )

                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());
                 return http.build();
    }
}