package com.example.AdminPermission;
import com.example.AdminPermission.Services.GlobalUserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final GlobalUserServices globalUserServices;

    public SecurityConfig(GlobalUserServices globalUserServices) {
        this.globalUserServices = globalUserServices;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.
                csrf(csrf -> csrf.disable())
                .authorizeHttpRequests((authorize)
                        -> authorize
                        .requestMatchers("/home").permitAll()
                        .requestMatchers("/auth/**").permitAll()

                        .requestMatchers("/api/**").authenticated()

                        .requestMatchers("/auth/admin/**").hasRole("ADMIN")
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/api/items/**").hasAnyRole("ADMIN", "USER")
                        .anyRequest().authenticated()
                ).formLogin(form -> form
                        .loginPage("/auth/login")
                        .usernameParameter("email")
                        .defaultSuccessUrl("/home") // Redirect after successful login
                        .permitAll()
                )
                .httpBasic(Customizer.withDefaults())
                .userDetailsService(globalUserServices)
        ;

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}