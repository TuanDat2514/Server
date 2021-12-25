/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.edu.huce.ltudm.n6.doan.chitieucanhan.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Administrator
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailServiceImp();
    }

    ;
 @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    ;
@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder()
        );
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http
                .csrf().disable()
                .httpBasic().and()
                .authorizeRequests()
                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .antMatchers("/auth/*").permitAll()//allow login api for all
                .antMatchers("/user/*").hasRole("USER")
                .antMatchers("/user/get/*").hasRole("USER")
                .antMatchers("/detail/all").hasRole("USER")
                .antMatchers("/detail/all/*").hasRole("USER")
                .antMatchers("/detail/add").hasRole("USER")
                .antMatchers("/wallet/get/*").hasRole("USER")
                 .antMatchers("/wallet/add/*").hasRole("USER")
                 .antMatchers("/wallet/*").hasRole("USER")
                 .antMatchers("/detail/tn/*").hasRole("USER")
                    .antMatchers("/detail/ct/*").hasRole("USER")
                .anyRequest().authenticated();
    }
}
