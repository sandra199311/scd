# 微服务Demo
代码结构：
```
|--scd
    |--scd-eureka 服务注册中心
    |--scd-gate 服务网关
    |--scd-config 配置中心
    |--scd-trace 链路追踪
    |--scd-admin 监控中心
    |--scd-turbine turbine聚合监控（聚合多个Hystrix Dashboard）
    |--scd-auth 授权中心
    |--scd-user 用户服务
    |--scd-demo 示例服务
    |--scd-common 公共组件
    |--scd-job 定时任务

```

| 服务名称 | 端口      |  访问地址  | 说明 |
| -------- | --------- | ---- | -------- |
| scd-eureka | 8761/8762 | http://localhost:8761/ | eureka  server |
| scd-gate | 8080 | 访问示例：http://localhost:8080/v1/user/hi?token=x&name=tom | zuul网关，集成zipkin、eureka  client、actuator |
| scd-config | 8090 |  | config server配置中心，集成eureka  client、actuator |
| scd-trace | 8100 | zipkin：http://locallost:8100 | zipkin server，集成eureka  client、actuator |
| scd-admin | 8110 | admin: http://locallost:8110 | admin server监控中心，集成eureka  client、actuator |
| scd-turbine | 8120 | turbine stream： http://localhost:8120/turbine.stream    Hystrix Dashboard：http://localhost:9010/hystrix | turbine server，集成hystrix dashboard、eureka  client、actuator |
| scd-auth | 8130 | http://localhost:8130/uaa | auth server授权中心，集成eureka  client |
| scd-user | 9001/9002 | 测试接口：http://172.20.46.181:9010/testFeign/hi?name=xx | 用户服务，集成zipkin、eureka  client、actuator |
| scd-demo | 9010 | 测试接口：http://172.20.46.181:9010/hi?name=xx | 示例服务，集成feign、ribbon、hystrix（不集成hystrix dashboard）、eureka  client、config client、actuator、zipkin |
| scd-common | |  | 公共服务，集成eureka  client                                 |
| scd-job     | 9020 |  | 定时任务服务，集成eureka  client |

 actuator地址：http://localhost:9001/actuator

启动顺序：scd-eureka->scd-config->scd-gate->scd-user->scd-demo/

启动多实例时，需在program arguments:中指定启动配置文件，例如：--spring.profiles.active=eureka2，指定配置文件application-eureka2.yml