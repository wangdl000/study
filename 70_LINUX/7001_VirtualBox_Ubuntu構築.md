## VirtualBox虚拟机中安装Ubuntu

语言选择时，我选的是日文。别问为什么！！！你能想象拿着日文键盘的电脑，去想象中文键盘按键位置，是怎样一种酸爽么。。。。  
https://blog.csdn.net/u012732259/article/details/70172704



## 目录




### 下载安装VirtualBox



### 分配共享数据空间
  **郑重声明：： 玩不明白文件夹共享，一下操作就别玩了。可怜我因为命令修改错误导致一晚上的操作化作乌有。（系统reboot）原因就是，“sudo gedit /etc/fstab” 命令执行后，ubuntushare写错了，导致和共享文件夹的固定分配名称不匹配**  
  **もちろん！　如果你跟我一样追求逼格的话，就一起趟雷吧！Good luck！**

  为了方便虚拟机和宿主机之间的数据传输，我们可以为虚拟机设置一个和主机共享的“数据空间”。VBox为我们提供了这个功能。  

  在VBox主界面左侧选择刚刚创建好的虚拟机，点击上方的“设置”按钮，进入虚拟机配置界面。点击左侧“共享文件夹”按钮，在新窗口中任意选择一个本地文件夹作为共享文件夹。  
  示例选择文件夹位置为C:\ubuntushare，不要勾选“只读分配”。单击“确定”，并关闭设置窗口。  

  图

  启动Ubuntu，打开终端窗口。（注意空格！）  
一个要点是：命令，文件名要通过Tab补全，这样就会减少录入错误。  
输入命令“sudo mkdir /mnt/shared”。回车后键入密码。
继续输入命令“sudo mount –t vboxsf ubuntushare /mnt/shared" //注意ubuntushare /mnt/shared 要跟据自己的情况修改  
输入命令“sudo gedit /etc/fstab”    
在弹出的文本末尾添加一行下面的内容：  
“ubuntushare /mnt/shared vboxsf rw,gid=100,uid=1000,auto 0 0”  
现在打开/mnt/shared文件夹，就可以看到主机对应共享文件夹rocshare中的内容了。这就是宿主机和虚拟机之间的桥梁。  
比如我们在Ubuntu中用touch命令新建一个testtest的文件，到宿主机的c://rocshare中就能看到这个文件。  

### 配置Ubuntu
Ubuntu的使用可以参考别出心裁的Linux命令学习法.  

通过sudo apt-get update;sudo apt-get upgrade 更新一下系统。  

### Ubuntu中支持yum命令

  - yum命令
yum（全称为 Yellow dog Updater, Modified）是一个在Fedora和RedHat以及SUSE中的Shell前端软件包管理器。  
  基於RPM包管理，能够从指定的服务器自动下载RPM包并且安装，可以自动处理依赖性关系，并且一次安装所有依赖的软体包，无须繁琐地一次次下载、安装。  
  yum提供了查找、安装、删除某一个、一组甚至全部软件包的命令，而且命令简洁而又好记。  

  - yum的命令形式一般是如下：yum [options] [command] [package ...]  

Ubuntu不支持yum命令。为了让Ubuntu操作起来更像Linux，先安装yum。
  - 1、检测是否安装了build-essential程序包  
  
    sudo apt-get install build-essential

  - 2、安装yum
  
    sudo apt-get install yum

  

