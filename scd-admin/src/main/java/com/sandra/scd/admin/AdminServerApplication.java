package com.sandra.scd.admin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 服务监控
 * @author sandra
 * @date 2019/9/11
 */
@SpringBootApplication
@EnableEurekaClient
@EnableAdminServer
public class AdminServerApplication {

    public static void main(final String[] args) {

        SpringApplication.run(AdminServerApplication.class, args);
    }

}
