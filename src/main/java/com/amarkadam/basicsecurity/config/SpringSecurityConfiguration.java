package com.amarkadam.basicsecurity.config;

import com.amarkadam.basicsecurity.service.PrincipleUserDetailsService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PrincipleUserDetailsService userDetailsService;

//    use below code for in memory security configuration
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        List<UserDetails> users = new ArrayList<>();
//        users.add(User.withDefaultPasswordEncoder().username("amar").password("admin").roles("ADMIN").build());
//        users.add(User.withDefaultPasswordEncoder().username("rama").password("admin").roles("USER").build());
//        users.add(User.withDefaultPasswordEncoder().username("aadi").password("admin").roles("USER").build());
//        return new InMemoryUserDetailsManager(users);
//    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf()
        .disable()
        .cors()
        .and().authorizeRequests()
        .antMatchers("/signup").permitAll()
        .antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/","/console/**").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .formLogin()
        .permitAll()
        .and()
        .logout()
        .permitAll()
        .and()
        .exceptionHandling()
        .accessDeniedPage("/403").and().headers().frameOptions().disable();
    }

    @Bean
    AuthenticationProvider getAuthenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return provider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(getAuthenticationProvider());
    }
}