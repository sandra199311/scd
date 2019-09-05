package com.sandra.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: sandra
 * @Description: 用户管理模块启动类
 * @Date: 2019/6/22 11:05
 **/
@SpringBootApplication
@EnableEurekaClient
public class UserApplication {

  public static void main(String[] args) {

    SpringApplication.run(UserApplication.class, args);
  }

}


