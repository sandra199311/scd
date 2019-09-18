package com.sandra.scd.demo.feignClient;

import com.sandra.scd.demo.config.FeignConfig;
import com.sandra.scd.demo.feignClient.hystrix.UserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: sandra
 * @Description: TODO
 * @Date: 2019/7/9 11:26
 **/
//Feign示例，并在Feign上使用熔断
@FeignClient(value = "scd-user", configuration = FeignConfig.class, fallback = UserHystrix.class)
public interface UserFeignClient {

    @GetMapping(value = "/hi")
    String hi(@RequestParam("name") String name);

}
