package com.sandra.scd.demo.web;

import com.sandra.scd.demo.service.FeignService;
import com.sandra.scd.demo.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sandra
 * @Description: DemoController
 * @Date: 2019/7/9 09:55
 **/
@RestController
public class DemoController {

    @Autowired
    RibbonService ribbonService;

    @Autowired
    FeignService feignService;

    @Value("${foo}")
    String foo;

    @GetMapping("/testRubbib/hi")
    public String hiTestRibbon(@RequestParam final String name) {

        return this.ribbonService.hi(name);
    }

    @GetMapping("/testFeign/hi")
    public String hiTestFeign(@RequestParam final String name) {

        return this.feignService.hi(name);
    }

    //测试是否可从配置中心读取配置项
    @RequestMapping(value = "/foo")
    public String foo() {

        return this.foo;
    }

}
