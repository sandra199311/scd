package com.sandra.demo.feignClient;

import com.sandra.demo.config.FeignConfig;
import com.sandra.demo.feignClient.hystrix.UserHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author: sandra
 * @Description: TODO
 * @Date: 2019/7/9 11:26
 **/
@FeignClient(value = "scd-user", configuration = FeignConfig.class, fallback = UserHystrix.class)
public interface UserFeignClient {

    @GetMapping(value = "/hi")
    String hi(@RequestParam("name") String name);

}
