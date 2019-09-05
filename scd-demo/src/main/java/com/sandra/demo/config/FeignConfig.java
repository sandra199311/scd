package com.sandra.demo.config;

import feign.Retryer;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: sandra
 * @Description: 覆盖Feign配置（默认配置类FeignClientsConfiguration）
 * @Date: 2019/7/9 11:22
 **/
@Configuration
public class FeignConfig {

  /**
   * 覆盖请求失败重试策略
   */
  @Bean
  public Retryer feignRetryer() {

    // 重试间隔100ms,最大重试时间1s，重试次数5次
    return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L), 5);
  }
}
