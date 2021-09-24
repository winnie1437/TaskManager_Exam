//package org.itstep.consumer.config;
//
//import org.itstep.consumer.services.UserService;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true,
//        proxyTargetClass = true,
//        securedEnabled = true)
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final UserService service;
//
//    public SecurityConfig(UserService service) {
//        this.service = service;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http.authorizeRequests()
//                .antMatchers("/css/**", "/js/**").permitAll()
//                .antMatchers("/").permitAll();
//
//        http.formLogin().loginPage("/login").permitAll()
//                .loginProcessingUrl("/auth").permitAll()
//                .usernameParameter("my_email")
//                .passwordParameter("password")
//                .successForwardUrl("/").defaultSuccessUrl("/")
//                .failureUrl("/login?error");
//
//        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login").permitAll();
//
//    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(service);
//    }
//
//
//}
