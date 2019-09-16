package com.sandra.scd.user.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sandra
 * @Description: demo
 * @Date: 2019/6/22 11:05
 **/
@RestController
public class HiController {

    @Value("${server.port}")
    String port;

    @GetMapping("/hi")
    public String hi(@RequestParam final String name) {

        return "hi " + name + ",i am from port:" + this.port;
    }

}
