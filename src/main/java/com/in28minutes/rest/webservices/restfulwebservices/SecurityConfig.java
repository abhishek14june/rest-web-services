package com.in28minutes.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private AuthenticationProvider authenticationProvider;
    /*
    Previously using WebSecurityConfigurer adapter
    @Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((authz) -> authz
                .anyRequest().authenticated()
            )
            .httpBasic(withDefaults());
    }

}
    * */
    //New approach using SecuirtyFilterChain is below
//    @Bean
//    SecurityFilterChain filterChain (HttpSecurity http) throws Exception {
//        http.authorizeHttpRequests((authorizationManagerRequestMatcherRegistry) ->
//                authorizationManagerRequestMatcherRegistry.anyRequest()
//                        .authenticated())
//                .httpBasic();
//        return http.build();
//    }

//    @Bean
//    AuthenticationManager authenticationManager() {
//
//    }

    /*
    * In memory authentication previously
    *
    * @Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        UserDetails user = User.withDefaultPasswordEncoder()
            .username("user")
            .password("password")
            .roles("USER")
            .build();
        auth.inMemoryAuthentication()
            .withUser(user);
    }
}
    *
    * */
 //New appraoch using InMemoryUserDetailsManager bean
    @Bean
    InMemoryUserDetailsManager userDetailsManager() {
        UserDetails userDetails = User.withUsername("user")
                .password(this.passwordEncoder().encode("password"))
                .roles("ADMIN")
                .build();
        return  new InMemoryUserDetailsManager(userDetails);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("")
                .permitAll()
                .anyRequest().authenticated()
                .and()
                .authenticationProvider(authenticationProvider);
        return  http.build();
    }
}

