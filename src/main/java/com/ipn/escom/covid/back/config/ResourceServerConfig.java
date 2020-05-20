package com.ipn.escom.covid.back.config;

import com.ipn.escom.covid.back.dto.UserDetailsImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Bean
    public CorsConfigurationSource getConfigurationSource() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource;
        urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowCredentials(true);
        configuration.setAllowedHeaders(Arrays.asList("*"));
        configuration.setAllowedOrigins(Arrays.asList("*")); // dev && prod url
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", configuration);
        return urlBasedCorsConfigurationSource;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http//
                .authorizeRequests()//
                .antMatchers(HttpMethod.POST, "/oauth/**").permitAll() //
                .antMatchers("/oauthAccessTokens/**").denyAll()
                .antMatchers("/oauthRefreshTokens/**").denyAll()
                .antMatchers("/admins/**").hasAuthority(UserDetailsImpl.ADMIN_ROLE)
                .antMatchers("/statistics/**").hasAuthority(UserDetailsImpl.ADMIN_ROLE)
                .anyRequest().authenticated() //
                .and().cors().configurationSource(getConfigurationSource());
    }
}
