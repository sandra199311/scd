package com.sandra.scd.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * WebSecurityConfig
 * @author sandra
 * @date 2019/9/19
 */
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.authorizeRequests()
                // oauth获取token、申请授权、登录等接口不需要授权
                .antMatchers("/oauth/**", "/").permitAll()
                .anyRequest().authenticated()  //所有请求都需要授权
                //使用默认登录页面,登录成功后跳转页面
                .and().formLogin().defaultSuccessUrl("/hello")
                //禁用csrf
                .and().csrf().disable();

    }

//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.userDetailsService(this.userDetailsService()).passwordEncoder(this.passwordEncoder());
//
//    }

    /**
     * 注入AuthenticationManager用来做验证
     * @return
     * @throws Exception
     */
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }

    /**
     * 注入用户信息
     * @return
     */
    @Bean
    @Override
    protected UserDetailsService userDetailsService() {

        final PasswordEncoder passwordEncoder = this.passwordEncoder();
        final String finalPassword = "{bcrypt}" + passwordEncoder.encode("123456");

        final InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("sandra").password(finalPassword).authorities("USER").build());

        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

}
