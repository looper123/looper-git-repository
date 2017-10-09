prefer-to-ip参数说明 （重要）
如果默认（false） 当服务向eureka注册时会以sample:8081的形式注册到loadBalance中(隐藏ip) 此时无法
用http://applicationName/mappingName的形式访问到该applicationName的服务,只能使用具体ip+port访问
（因为它自己也无法识别放进去的是什么地址）
为true时 会以真实ip  127.0.0.1：8081的形式注册到loadbalance中