package com.sandra.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: lenovo
 * @Description: TODO
 * @Date: 2019/7/10 11:21
 **/
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigServerApplication {

  public static void main(String[] args) {

    SpringApplication.run(ConfigServerApplication.class, args);
  }
}
