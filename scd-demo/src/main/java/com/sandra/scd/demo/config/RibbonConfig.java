package com.sandra.scd.demo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author: sandra
 * @Description: RabbonConfig
 * @Date: 2019/7/9 09:49
 **/
@Configuration
public class RibbonConfig {

    /**
     * Ribbon与远程调用类RestTemplate结合，进行负载均衡
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {

        return new RestTemplate();
    }

}
