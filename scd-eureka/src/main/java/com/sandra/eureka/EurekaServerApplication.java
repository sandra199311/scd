package com.sandra.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: sandra
 * @Description: EurekaServer启动类
 * @Date: 2019/6/22 11:05
 **/
@EnableEurekaServer
@SpringBootApplication
public class EurekaServerApplication {

  public static void main(String[] args) {

    SpringApplication.run(EurekaServerApplication.class, args);
  }
}
