package com.sandra.scd.demo.service;

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

    //在restTemplate和ribbon上使用熔断
    @HystrixCommand(fallbackMethod = "hiError")
    public String hi(final String name) {

        return this.restTemplate.getForObject("http://scd-user/hi?name=" + name, String.class);
    }

    public String hiError(final String name) {

        return "hi," + name + ",sorry,error!";
    }

}
