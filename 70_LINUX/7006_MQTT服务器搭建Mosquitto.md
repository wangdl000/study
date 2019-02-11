## MQTT服务器搭建--Mosquitto
2019/02/10

不经意间，用Linux命令实现了Ubuntu与Windows10之间共享文件夹。  
（具体实现见7004_Windows访问Ubuntu共享文件夹）  
虽然用直接Ctrl~C 也可以做到，但是就不滴。作为资深码农，逼格还是要有滴。。。  
接下来就可以继续去年（2018/12）发下的宏源，完整系统的学习MQTT。  
首先从环境构筑开始。。

### 1. MQTT
MQTT 是一个轻量级即时通信协议，使用基于 TCP/IP 协议的发布/订阅消息转发模式， MQTT 协议的中心是 broker（ 服务器/代理），客户端通过订阅消息和发布消息进行数据交互。   
若初次接触MQTT协议，可先理解以下概念：   
【MQTT协议特点】——相比于RESTful架构的物联网系统，MQTT协议借助消息推送功能，可以更好地实现远程控制。   
【MQTT协议角色】——在RESTful架构的物联网系统，包含两个角色客户端和服务器端，而在MQTT协议中包括发布者，代理器（服务器）和订阅者。   
【MQTT协议消息】——MQTT中的消息可理解为发布者和订阅者交换的内容（负载），这些消息包含具体的内容，可以被订阅者使用。   
【MQTT协议主题】——MQTT中的主题可理解为相同类型或相似类型的消息集合。  

Mosquitto是一款实现了 MQTT v3.1 协议的开源消息代理软件，包括了服务器端和客户端，可以跨平台部署，提供轻量级的，支持发布/订阅的的消息推送模式，使设备对设备之间的短消息通信简单易用。  

### 2.安装mosquitto前期准备
	
    yum install gcc-c++
    yum install cmake
    yum install openssl-devel //mosquitto默认支持openssl

  **当然上面的命令不好用，因为他是Linux的命令。如果你的Ubuntu安装了yum，又会提示你需要root权限。更改root权限不安全，因此用sudo apt-get来安装软件。**  
    
    sudo apt-get install gcc-6 g++-6
    sudo apt-get install cmake
    sudo apt-get install openssl
    sudo apt-get install libssl-dev //mosquitto默认支持openssl

    ----sudo apt-get install vim // 编译安装mosquito用
  为了防止mosquitto安装时出错，事先安装以下三个包  
  - 【1】编译找不到openssl/ssl.h  
    【解决方法】——安装openssl  

    sudo apt-get install libssl-dev
  - 【2】编译过程找不到ares.h  
    
    sudo apt-get install libc-ares-dev
  - 【3】编译过程找不到uuid/uuid.h  
    
    sudo apt-get install uuid-dev
    
    sudo apt-get install g++

    sudo apt-get install libc-ares-dev

#### 2.1 安装mosquitto并更新
    sudo apt-add-repository ppa:mosquitto-dev/mosquitto-ppa
    udo apt-get update
    sudo apt-get install mosquitto
#### 2.2 查看mosquitto服务状态、开启/停止mosquitto服务

    sudo service mosquitto status
    sudo service mosquitto start
    sudo service mosquitto stop
#### 2.3 安装mosquitto客户端
    sudo apt-get install mosquitto mosquitto-clients 



### 3.mqtt测试

#### 3.1 启动mosquitto（服务器代理启动　←　专业术语）
  
    mosquitto -v

#### 3.2 新窗口输入以下测试命令（使用mosquitto_sub订阅一个主题　←　专业术语）
  
    mosquitto_sub -h localhost -t "mqtt" -v

  在3.1的窗口中会输出以下log：  

    1549853663: New connection from 127.0.0.1 on port 1883.
    1549853663: New client connected from 127.0.0.1 as mosqsub|7817-oudenryou5 (c1, k60).
    1549853663: No will message specified.
    1549853663: Sending CONNACK to mosqsub|7817-oudenryou5 (0, 0)
    1549853663: Received SUBSCRIBE from mosqsub|7817-oudenryou5
    1549853663: 	mqtt (QoS 0)
    1549853663: mosqsub|7817-oudenryou5 0 mqtt
    1549853663: Sending SUBACK to mosqsub|7817-oudenryou5

#### 3.3 第三个新窗口输入以下命令(使用mosquitto_pub命令推送消息　←　专业术语)

    mosquitto_pub -h localhost -t "mqtt" -m "Hello2 mqtt"

  在3.1的窗口中输出以下log，则表示环境构筑成功。  

    mqtt Hello2 mqtt
  同时，在3.2的窗口中输出以下log

    1549853724: New connection from 127.0.0.1 on port 1883.
    1549853724: New client connected from 127.0.0.1 as mosqpub|7818-oudenryou5 (c1, k60).
    1549853724: No will message specified.
    1549853724: Sending CONNACK to mosqpub|7818-oudenryou5 (0, 0)
    1549853724: Received PUBLISH from mosqpub|7818-oudenryou5 (d0, q0, r0, m0, 'mqtt', ... (11 bytes))
    1549853724: Sending PUBLISH to mosqsub|7817-oudenryou5 (d0, q0, r0, m0, 'mqtt', ... (11 bytes))
    1549853724: Received DISCONNECT from mosqpub|7818-oudenryou5
    1549853724: Client mosqpub|7818-oudenryou5 disconnected.
    1549853783: Received PINGREQ from mosqsub|7817-oudenryou5
    1549853783: Sending PINGRESP to mosqsub|7817-oudenryou5

  从此以后，陷入MQTT消息队列的海洋里，无法自拔。。。  


### 4.MQTT原理
  环境调试完成。通过下图理解一下MQTT原理。。
  ![7006](https://github.com/wangdl000/study/blob/master/resource/70_linux/70_7006/mqtt.png)



****
㊦ 以下请无视 
****


### 1、在Ubuntu上搭建Mosquitto
  - Mosquitto下载  
  依然用命令。 直接用鼠标点的（http://mosquitto.org/download/），那是小学生玩的。  

  - 需要准备的文件：
    - mosquitto-1.4.11.tar.gz  
    - libwebsockets-v1.6-stable.tar.gz  
  
    wget http://mosquitto.org/files/source/mosquitto-1.5.6.tar.gz
    tar -xzvf mosquitto-1.5.6.tar.gz
    cd mosquitto-1.5.6

  - 编译安装  
  config.mk包括了多个选项, 可按需关闭或开启，但一旦开启则需要先安装对应的模块  
  ****
    - WITH_SRV  
    启用c-areas库的支持，一个支持异步DNS查找的库  
    见http://c-ares.haxx.se
    make出错信息:missing ares.h

    - WITH_UUID  
    启用lib-uuid支持，支持为每个连接的客户端生成唯一的uuid  
    make出错信息: missing uuid.h

    - WITH_WEBSOCKETS  
    启用websocket支持，需安装libwebsockets  
    对于需要使用websocket协议的应用开启  
    make出错信息: missing libwebsockets.h
  ****
  - 通过vim config.mk命令来更改配置信息。 对于初学者来说更改配置文件，会发生各种奇葩问题，这里就不更改了，直接把可能用到的软件事先都安装全了。。。  
  
****    
    cd mosquitto-1.5.6
    make
    sudo make install
****   


### 2 简单测试
    一个完整的MQTT示例包括一个代理器，一个发布者和一个订阅者。测试分为以下几个步骤：  

  - 【1】启动服务mosquitto。  
  - 【2】订阅者通过mosquitto_sub订阅指定主题的消息。  
  - 【3】发布者通过mosquitto_pub发布指定主题的消息。  
  - 【4】代理服务器把该主题的消息推送到订阅者。  

#### 2.1 启动代理服务
    mosquitto -v
    【-v】打印更多的调试信息  
### 2.2 订阅主题
    mosquitto_sub -v -t sensor
    【-t】指定主题，此处为sensor  
    【-v】打印更多的调试信息  
### 2.3 发布内容

    mosquitto_pub -t sensor  -m 12
    【-t】指定主题  
    【-m】指定消息内容  
### 2.4 运行结果
    当发布者推送消息之后，订阅者获得以下内容  

    sensor 12
  
  参考资料如下：  
https://blog.csdn.net/MENGHUANBEIKE/article/details/75213005

https://blog.csdn.net/tozheng/article/details/52788898

### 2、安装c-areas  
  （傻瓜式安装路径：https://c-ares.haxx.se/download/）  
  命令如下：  

    wget http://c-ares.haxx.se/download/c-ares-1.14.0.tar.gz
    cd c-ares-1.14.0
    ./configure
    make
    sudo make install