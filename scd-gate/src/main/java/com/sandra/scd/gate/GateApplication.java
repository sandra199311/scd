package com.sandra.scd.gate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author: sandra
 * @Description: 网关启动类
 * @Date: 2019/6/22 11:05
 **/

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
@EnableHystrix
@EnableHystrixDashboard
public class GateApplication {

    public static void main(final String[] args) {

        SpringApplication.run(GateApplication.class, args);
    }

}
