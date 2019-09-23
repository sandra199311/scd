package com.sandra.scd.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {

        return "hello world!";
    }

    @RequestMapping("/")
    public String test() {

        return "home page!";
    }

}
