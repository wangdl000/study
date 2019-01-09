## VirtualBox虚拟机中安装Ubuntu


https://blog.csdn.net/u012732259/article/details/70172704


## 目录




### 下载安装VirtualBox







### 分配共享数据空间

  为了方便虚拟机和宿主机之间的数据传输，我们可以为虚拟机设置一个和主机共享的“数据空间”。VBox为我们提供了这个功能。  

  在VBox主界面左侧选择刚刚创建好的虚拟机，点击上方的“设置”按钮，进入虚拟机配置界面。点击左侧“共享文件夹”按钮，在新窗口中任意选择一个本地文件夹作为共享文件夹。  
  示例选择文件夹位置为C:\rocshare，不要勾选“只读分配”。单击“确定”，并关闭设置窗口。  

  图

  启动Ubuntu，打开终端窗口。（注意空格！）  
一个要点是：命令，文件名要通过Tab补全，这样就会减少录入错误。  
输入命令“sudo mkdir /mnt/shared”。回车后键入密码。
继续输入命令“sudo mount –t vboxsf rocshare /mnt/shared" //注意rocshare /mnt/shared 要跟据自己的情况修改  
输入命令“sudo gedit /etc/fstab”    
在弹出的文本末尾添加一行下面的内容：  
“rocshare /mnt/shared vboxsf rw,gid=100,uid=1000,auto 0 0”  
现在打开/mnt/shared文件夹，就可以看到主机对应共享文件夹rocshare中的内容了。这就是宿主机和虚拟机之间的桥梁。  
比如我们在Ubuntu中用touch命令新建一个testtest的文件，到宿主机的c://rocshare中就能看到这个文件。  

### 配置Ubuntu
Ubuntu的使用可以参考别出心裁的Linux命令学习法.  

通过sudo apt-get update;sudo apt-get upgrade 更新一下系统。  


