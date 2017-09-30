#启动项
spring boot启动项目必须置于该项目所有包的根目录下

#注册
unknown host exception
1 prefer-ip-address 作用：向注册中心注册时 如果该配置false（默认） 会以 sample:8081(spring.application.name:port)的
形式向loadBalance中注册 ；当设置为true时，会以 127.0.0.1:8081（ip:port）的形式向loadBalance中注册
2 restTemplate类初始化时没有加上@loadBalanced注解 (loadBalance类没有加载对应 instance（spring.application.name） 的ip
到serverList中) 所以无法获取到真正的ip

#ribbon 对调用的服务实现负载均衡
@BalanceLoader
默认策略 ：
消费者会优先访问处于同一个zone下的服务,如果没有再去寻找其他zone的服务

#关于spring-cloud endpoint说明
需要引入spring-boot-starter-actuator包 spring-cloud 下所有组件 eureka、configserver、consumer、provider。。。都可以访问
endpoint信息（example ： host:ip/env）

#circuitBreaker
hystirx为了保证不会因为某个依赖服务问题影响到其他服务采用了bulkheader parttern(舱壁模式) 隔离每个服务
