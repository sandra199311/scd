package com.sandra.scd.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 授权中心
 * @author sandra
 * @date 2019/9/19
 */
@SpringBootApplication
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class AuthServerApplication {

    public static void main(final String[] args) {

        SpringApplication.run(AuthServerApplication.class, args);
    }

}
