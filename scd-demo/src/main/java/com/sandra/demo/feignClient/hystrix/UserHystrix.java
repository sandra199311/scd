package com.sandra.demo.feignClient.hystrix;

import com.sandra.demo.feignClient.UserFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author: lenovo
 * @Description: TODO
 * @Date: 2019/7/9 17:03
 **/
@Component
public class UserHystrix implements UserFeignClient {

    @Override
    public String hi(final String name) {

        return "error";
    }

}
