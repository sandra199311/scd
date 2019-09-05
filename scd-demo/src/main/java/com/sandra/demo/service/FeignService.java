package com.sandra.demo.service;

import com.sandra.demo.feignClient.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: sandra
 * @Description: TODO
 * @Date: 2019/7/9 11:23
 **/
@Service
public class FeignService {

  @Autowired
  UserFeignClient userFeignClient;

  public String hi(String name) {

    return userFeignClient.hi(name);
  }

}
