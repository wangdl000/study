## Windows访问Ubuntu共享文件夹
有时候我们需要在windows中方便的访问修改Linux中的文件夹，可以使用samba方便的完成这种操作，类似于windows和windows之间的文件夹共享。  

### 具体的配置和操作过程：

  - 1、确认系统中安装samba  

    sudo apt-get install samba  

  执行过程如下图：  
  ![ ](https://github.com/wangdl000/study/blob/master/resource/70_7004/7004_01.png) 

  - 2、设置你的账户samba密码  
    
    sudo touch /etc/samba/smbpasswd  
    sudo smbpasswd -a usr    #usr 表示你的用户名  
    然后按照提示输入密码就可以了。  

    执行过程如下图：  
  ![ ](https://github.com/wangdl000/study/blob/master/resource/70_7004/7004_02.png) 
    
  - 3、将你的用户添加到sambashare用户组中  

    sudo adduser usr sambashare  
    logout后重新的登录，当前用户就可以共享文件夹了。

    执行过程如下图：  
  ![ ](https://github.com/wangdl000/study/blob/master/resource/70_7004/7004_03.png) 

  - 4、具体共享文件方法  
  右击你想共享的文件夹，点击本地网络共享，然后点击共享文件夹就可以了。

  - 5、怎么在Windows中访问这个共享文件夹  
  方法跟Windows访问Windows是一样的，按Windows+R，然后输入

    //服务器ip地址

### Ubuntu16.04で固定IPアドレスを設定する方法(CUI編)


  -  Ubuntuにifconfigをインストール
    sudo apt install net-tools
  - linux系统(ubuntu)如何查看ip地址
    ifconfig -a

https://ygkb.jp/3672

>sudo vi /etc/network/interfaces

Change from:

auto lo
iface lo inet loopback

allow-hotplug eth0
iface eth0 inet static
  address 192.168.56.5
  netmask 255.255.255.0
  gateway 192.168.56.1
Change to:

auto lo
iface lo inet loopback

allow-hotplug enp0s3
iface enp0s3 inet static
  address 192.168.56.5
  netmask 255.255.255.0
  gateway 192.168.56.1



>sudo service networking restart
>sudo reboot

操作命令

http://www.gi.ce.t.kyoto-u.ac.jp/user/susaki/command/vi.html
http://server-ope.com/?p=156

### 参考资料
  - ubuntu18访问win10共享文件  
https://www.jianshu.com/p/900aa7acfeef

https://blog.csdn.net/xuan314708889/article/details/80418888

  - WinSCP  
  Linux（Ubuntu18.04）和Windows10 之间的局域网文件传输  
https://blog.csdn.net/HelloZEX/article/details/80784375

