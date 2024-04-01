package com.eazybytes.config;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /*
         * Below is the custom security configurations
         * */

        http.authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/myAccount", "myBalance", "myLoans", "myCards").authenticated()   // 인증 필요
                        .requestMatchers("/notices", "/contact").permitAll())   // 인증 불필요
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();

        /*
        * Configuration to deny all the requests
        * */

        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().denyAll())   // 모든 요청 거부
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();*/

        /*
        * Configuration to permit all the requests
        * */

        /*http.authorizeHttpRequests((requests) -> requests.anyRequest().permitAll())   // 모든 요청 허용
                .formLogin(withDefaults())
                .httpBasic(withDefaults());
        return http.build();*/
    }
}
