package com.sandra.scd.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: sandra
 * @Description: 定时任务模块启动类
 * @Date: 2019/6/22 11:05
 **/
@SpringBootApplication
public class JobApplication {

    public static void main(final String[] args) {

        SpringApplication.run(JobApplication.class, args);
    }

}
