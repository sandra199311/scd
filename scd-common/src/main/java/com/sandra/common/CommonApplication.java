package com.sandra.common;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: lenovo
 * @Description: TODO
 * @Date: 2019/7/10 11:21
 **/
@SpringBootApplication
@EnableEurekaClient
public class CommonApplication {

  public static void main(String[] args) {

    SpringApplication.run(CommonApplication.class, args);
  }
}
