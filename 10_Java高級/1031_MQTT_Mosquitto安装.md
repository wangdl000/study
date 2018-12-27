## MQTT的学习之Mosquitto安装&使用

## 目录

> **1、编译与安装OpenSSL**  
> **2、MQTT的学习之Mosquitto安装**  
> **3、**  
> **4、**  
  

## 1、编译与安装OpenSSL

prefix 是安装目录，openssldir 是配置文件目录，另外建议安装两次，shared 作用是生成动态连接库。   
linux版的OpenSSL下载地址为：https://www.openssl.org/source/，我所使用的是openssl-1.1.0f.tar.gz版本，并且将mosquitto-1.4.14.tar.gz提前也上传至该目录下并解压，后面会使用。  

#### 1、上传下载好的压缩包，并解压：  





#### 2、在/home/tool下创建文件夹openssl作为安装路径，在openssl下创建files文件夹；然后，cd到openssl-1.1.0f文件夹下：  


#### 3、执行命令  

    1、  ./config --prefix=/home/tool/openssl --openssldir=/home/tool/openssl/files
    
    2、  make && make install
    
    3、  ./config shared --prefix=/home/tool/openssl --openssldir=/home/tool/openssl/files
    4、 make clean　　
    
    5、 make && make  install

#### openssl安装完毕。

## 2、MQTT的学习之Mosquitto安装  

  Mosquitto是一个实现了MQTT3.1协议的代理服务器，由MQTT协议创始人之一的Andy Stanford-Clark开发，它为我们提供了非常棒的轻量级数据交换的解决方案。本文的主旨在于记录Mosquitto服务的安装和使用，以备日后查阅。  

### 2.1、安装  
https://www.cnblogs.com/chen1-kerr/p/7258487.html

https://www.cnblogs.com/chen1-kerr/p/7258487.html