# spring cloud stream 消息驱动（spring boot + spring integration）
# 支持kafka、rabbitmq
# 核心概念
绑定器 发布-订阅模式 消费组 消费分区

#rabbitmq 安装 步骤简述(windwos环境)
Erlang：http://www.erlang.org/download.html
RabbitMQ ：http://www.rabbitmq.com/download.html

环境变量配置
ERLANG_HOME=C:\Program Files\erl8.1
RABBITMQ_HOME=D:\java\RabbitMQ\rabbitmq_server-3.6.12

path 最前面添加 %ERLANG_HOME%\bin;%RABBITMQ_HOME%\sbin
配置完成检查 dos下输入 rabbitmq-service 验证下
启动注意 ：在启动rabbitmq之前（rabbitmq-server.bat） 需要在本地服务中（dos下 services.msc ）查看下
rabbit是否已经启动  否则会报 （rabbit node 已经存在的错误）








