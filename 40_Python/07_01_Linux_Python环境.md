## Python环境搭建

### 安装gcc：
  要问为什么。。。。  
  维基百科告诉你  
  - GCC  
  https://zh.wikipedia.org/wiki/GCC

#### 运行命令安装GCC
    sudo apt-get install gcc


#### 通过ubuntu官方的apt工具包安装python
     
    wget -c https://www.python.org/ftp/python/3.7.2/Python-3.7.2.tgz

#### 将Python-3.7.2.tgz解压
    
    tar -xzvf Python-3.7.2.tgz

#### 下面的命令进行确认
    ls  
#### 用下面的命令 移动Python文件夹
    sudo cp -r Python-3.7.2 /usr/local/python

    sudo cp -r Python-3.7.2 /usr/local/python
#### 运行configure文件

    sudo ./configure

#### 用如下命令查看版本
    python --version   

#### 用如下命令进入Python
    python3

   运行后    
  
    Python 3.6.5 (default, Apr  1 2018, 05:46:30) 
    [GCC 7.3.0] on linux
    Type "help", "copyright", "credits" or "license" for more information.
    >>> 

#### 入门级输出hello word
   输入如下命令  

    >>> print("Hello World")
    Hello World
    >>> 

### 小结
  Python编程就不玩了。 都是高级编程语言，基础部分一同百通。
