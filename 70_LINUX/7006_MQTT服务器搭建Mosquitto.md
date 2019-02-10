## MQTT服务器搭建--Mosquitto
2019/02/10

不经意间，用Linux命令实现了Ubuntu与Windows10之间共享文件夹。  
（具体实现见7004_Windows访问Ubuntu共享文件夹）  
虽然用直接Ctrl~C 也可以做到，但是就不滴。作为资深码农，逼格还是要有滴。。。  
接下来就可以继续去年（2018/12）发下的宏源，完整系统的学习MQTT。  
首先从环境构筑开始。。


### 前期准备
	
    yum install gcc-c++
    yum install cmake
    yum install openssl-devel //mosquitto默认支持openssl

  **当然上面的命令不好用，因为他是Linux的命令。如果你的Ubuntu安装了yum，又会提示你需要root权限。更改root权限不安全，因此用sudo apt-get来安装软件。**  
    
    sudo apt-get install gcc-c++
    sudo apt-get install cmake
    sudo apt-get install openssl
    sudo apt-get install libssl-dev //mosquitto默认支持openssl

    ----sudo apt-get install vim // 编译安装mosquito用
    

### 1、在Ubuntu上搭建Mosquitto
  - Mosquitto下载  
  依然用命令。 直接用鼠标点的（http://mosquitto.org/download/），那是小学生玩的。  

  - 需要准备的文件：
  mosquitto-1.4.11.tar.gz，libwebsockets-v1.6-stable.tar.gz

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
  
    
    make
    -----
  
  参考资料如下：  
  https://blog.csdn.net/tozheng/article/details/52788898

### 2、安装c-areas  
  （傻瓜式安装路径：https://c-ares.haxx.se/download/）  
  命令如下：  

    wget http://c-ares.haxx.se/download/c-ares-1.14.0.tar.gz
    cd c-ares-1.14.0
    ./configure
    make
    sudo make install