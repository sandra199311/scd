package com.sandra.demo.web;

import com.sandra.demo.service.FeignService;
import com.sandra.demo.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: sandra
 * @Description: RibbonController
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

  @GetMapping("/hi")
  public String hi(@RequestParam String name) {

    return ribbonService.hi(name);
  }

  @GetMapping("/hi1")
  public String hi1(@RequestParam String name) {

    return feignService.hi(name);
  }

  @RequestMapping(value = "/foo")
  public String foo() {

    return foo;
  }

}
