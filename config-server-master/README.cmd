prefer-to-ip参数说明 （重要）
如果默认（false） 当服务向eureka注册时会以sample:8081的形式注册到loadBalance中(隐藏ip) 此时无法
用http://applicationName/mappingName的形式访问到该applicationName的服务,只能使用具体ip+port访问
（因为它自己也无法识别放进去的是什么地址）
为true时 会以真实ip  127.0.0.1：8081的形式注册到loadbalance中


#spring cloud bus+kafka 实现配置消息分发
#启动zookeeper
bin\windows\zookeeper-server-start.bat config\zookeeper.properties

#启动kafka
bin\windows\kafka-server-start.bat config\server.properties

#创建一个名为test的topic 其中包含了一个replication和一个partition分区
kafka-topics.bat --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

#查看刚创建完的topic
kafka-topics.bat --list --zookeeper localhost:2181

#创建消息生产者
kafka-console-producer.bat --broker-list localhost:9092 --topic test

#创建消息消费者
kafka-console-consumer.bat --zookeeper localhost:2181 --topic test --from-beginning



