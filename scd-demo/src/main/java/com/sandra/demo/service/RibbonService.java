package com.sandra.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author: sandra
 * @Description: TODO
 * @Date: 2019/7/9 09:55
 **/
@Service
public class RibbonService {

  @Autowired
  RestTemplate restTemplate;

  @HystrixCommand(fallbackMethod = "hiError")
  public String hi(String name) {

    return restTemplate.getForObject("http://scd-user/hi?name=" + name, String.class);
  }

  public String hiError(String name) {

    return "hi," + name + ",sorry,error!";
  }

}
