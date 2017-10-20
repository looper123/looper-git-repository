# 对hello-service 服务进行跟踪
实现原理
当请求到达入口时，为该请求创建一个唯一的表示traceID,该请求在分布式服务内部流转时，会始终保持这个traceID
当请求到达各个服务或者到达某个状态时，sleuth会通过spanId来区分调用的各个阶段（span），并且span中包含了 开始节点 和结束
节点和其他的元数据，可以用来统计各阶段服务调用所花费的时间
在介入sleuth后 它会默认帮助我们跟踪当前应用中的消息通道
1 spring cloud stream 绑定器实现的消息中间件
2 通过zuul网关代理后的请求
3 通过restTemplate发起的请求





