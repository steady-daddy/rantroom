package com.webapp.rantsroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

import com.webapp.rantsroom.model.Role;

// TODO: FIgure out its functionality
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
      return authenticationManager();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/resources/**","/","/home","/confirm","/verify").permitAll()
                    .antMatchers("/users/**").authenticated()
                    //.antMatchers("/post").authenticated()
                    //.antMatchers("/postsuccess").hasAnyRole()
//                    .antMatchers("/post").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//                    .antMatchers("/postsuccess").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
                    .anyRequest().permitAll()
                    .and()
                .formLogin()
                    .loginPage("/login").failureUrl("/login?error")
                    .defaultSuccessUrl("/users/welcome")                    
                    .permitAll()
                    .and()
                .logout()
                    .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
    }
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/home","/");
	}
    
}