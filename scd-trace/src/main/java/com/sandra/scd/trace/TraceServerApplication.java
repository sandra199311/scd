package com.sandra.scd.trace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.internal.EnableZipkinServer;

/**
 * @author sandra
 * @date 2019/9/11
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer
public class TraceServerApplication {

    public static void main(final String[] args) {

        SpringApplication.run(TraceServerApplication.class, args);
    }

}
