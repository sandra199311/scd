package com.sandra.scd.auth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/me")
    public Principal me(final Principal principal) {

        return principal;
    }

}
