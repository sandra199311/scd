# 微服务Demo
代码结构：
```
|--scd
    |--scd-eureka 服务注册中心
    |--scd-gate 服务网关
    |--scd-config 配置中心
    |--scd-auth 授权中心
    |--scd-user 用户服务
    |--scd-demo 示例服务
    |--scd-job 定时任务
    |--scd-common 公共组件
    |--scd-monitor 监控中心
    |--scd-trace 链路追踪
```

网关访问地址：
http://localhost:9015//v1/user/hi?token=x&name=tom