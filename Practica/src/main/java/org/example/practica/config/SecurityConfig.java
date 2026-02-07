package org.example.practica.config;

import org.example.practica.enumerados.Rol;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.headers(h -> h.frameOptions(HeadersConfigurer.FrameOptionsConfig::sameOrigin));

        http.authorizeHttpRequests(auth -> auth

//                //Estaticos
//                .requestMatchers(PathRequest.toStaticResources().atCommonLocations()).permitAll()

                //Publico
                .requestMatchers("/", "/listaVecinos").permitAll()

                .requestMatchers("/crearVecino/**", "/crearVecino/**").hasRole(Rol.ADMIN.toString())

                .requestMatchers("/editarVecino/**").hasAnyRole(Rol.MANAGER.toString(), Rol.ADMIN.toString())

                .anyRequest().authenticated()
        );

        // login form
        http.formLogin(form -> form
                .loginProcessingUrl("/api/auth/login")
                .defaultSuccessUrl("/listaVecinos", true)
                .permitAll()
        );

        http.logout(logout -> logout.permitAll());

        return http.build();
    }

}
