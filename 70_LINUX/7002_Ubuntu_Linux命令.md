## Ubuntu Linux基本命令

ubuntu没有盘符这个概念，只有一个根目录/，所有文件都在它下面
　　　unix-tree

　　Linux 目录

/：根目录，一般根目录下只存放目录，在Linux下有且只有一个根目录。所有的东西都是从这里开始。当你在终端里输入“/home”，你其实是在告诉电脑，先从/（根目录）开始，再进入到home目录
/bin: /usr/bin: 可执行二进制文件的目录，如常用的命令ls、tar、mv、cat等。
/boot：放置linux系统启动时用到的一些文件，如Linux的内核文件：/boot/vmlinuz，系统引导管理器：/boot/grub。
dev：存放linux系统下的设备文件，访问该目录下某个文件，相当于访问某个设备，常用的是挂载光驱 mount /dev/cdrom /mnt。
/etc：系统配置文件存放的目录，不建议在此目录下存放可执行文件，重要的配置文件有 /etc/inittab、/etc/fstab、/etc/init.d、/etc/X11、/etc/sysconfig、/etc/xinetd.d。
/home：系统默认的用户家目录，新增用户账号时，用户的家目录都存放在此目录下，~表示当前用户的家目录，~edu 表示用户 edu 的家目录。
/lib: /usr/lib: /usr/local/lib：系统使用的函数库的目录，程序在执行过程中，需要调用一些额外的参数时需要函数库的协助。
/lost+fount：系统异常产生错误时，会将一些遗失的片段放置于此目录下。
/mnt: /media：光盘默认挂载点，通常光盘挂载于 /mnt/cdrom 下，也不一定，可以选择任意位置进行挂载。
/opt：给主机额外安装软件所摆放的目录。
/proc：此目录的数据都在内存中，如系统核心，外部设备，网络状态，由于数据都存放于内存中，所以不占用磁盘空间，比较重要的目录有 /proc/cpuinfo、/proc/interrupts、/proc/dma、/proc/ioports、/proc/net/* 等。
/root：系统管理员root的家目录。
/sbin: /usr/sbin: /usr/local/sbin：放置系统管理员使用的可执行命令，如fdisk、shutdown、mount 等。与 /bin 不同的是，这几个目录是给系统管理员 root使用的命令，一般用户只能"查看"而不能设置和使用。
/tmp：一般用户或正在执行的程序临时存放文件的目录，任何人都可以访问，重要数据不可放置在此目录下。
/srv：服务启动之后需要访问的数据目录，如 www 服务需要访问的网页数据存放在 /srv/www 内。
/usr：应用程序存放目录，/usr/bin 存放应用程序，/usr/share 存放共享数据，/usr/lib 存放不能直接运行的，却是许多程序运行所必需的一些函数库文件。/usr/local: 存放软件升级包。/usr/share/doc: 系统说明文件存放目录。/usr/share/man: 程序说明文件存放目录。
/var：放置系统执行过程中经常变化的文件，如随时更改的日志文件 /var/log，/var/log/message：所有的登录文件存放目录，/var/spool/mail：邮件存放的目录，/var/run:程序或服务启动后，其PID存放在该目录下。
几个常用命令细讲：
　　一个程序猿可能都听说过的笑话。说，一个二流程序猿带着电脑在咖啡馆，看到一个美女，就做到妹子眼睛看的到的地方打开ubuntu terminal，输入， $>tree / ，然后（懂得人肯定明白了，不懂的快去试试）......，新学一招和妹子搭讪的技术。

　　linux commands一般都有几部分构成： commands [-options] [parameter1]... ，也就是：命令　　选项　　参数1...（可能有多个参数，选项也可能有多个）。

　　pwd：显示当前路径。

　　cd（change directory）：改变当前目录。

 

　　ls：显示当前文件夹下未被隐藏的文件或文件夹。

　　　　

复制代码
ls -a                    显示所有文件和文件夹（包括隐藏的）。
ls -l                    以列表的方式显示（列表里有大小，无单位）。
ls -h                    大小自动显示为带有单位的，如3.6K。
ls -a -l -h
ls -h -l -a
ls -alh
ls -lha                  以上四个操效果一样。
复制代码
　　

　　 commands --help/man commands ：显示帮助手册。注意：man（Manuel）手册一共有8个。

 

　　 mkdir foldername ：新建文件夹，后面加的是文件夹名。

　　 mkdir /A/B/C/D/E -p ：自动创建依赖文件夹，若没有B，C，D的话就自动创建。　

　

　　 touch filename ：创建文件。

 

　　 rmdir foldername ：仅可以删除空文件夹。（rm表示 remove）

　　 rm -r foldername ：可以递归删除文件夹，操作文件夹是被限制可以尝试加，“-r”：表示递归。

　　 mv filename 目标地址 ：(mv：move，实际操作中是剪切的意思)，移动文件到目标地址。

　　 mv filename newfilename ：重命名。

　　 cp filename destAdd ：（cp：copy，复制），复制文件到目标地址。

　　 cp foldername destAdd -r ：复制文件夹到目标地址，操作文件夹是被限制可以尝试加，“-r”：表示递归。

 

　　 history ：显示所有历史命令，并且前有命令标号。用 ！number ！+ 对应命令的标号，相当于运行该命令。

 

　　 cat filename ：只能查看不可以编辑文件里面的内容，所以后面一定加的是文件名不是文件夹的名。

　　 more filename ：同样也是查看文件内容，但是前者是一下显示到底，后者是分屏慢慢显示，可控制的慢慢查看。press “q” exit。

　　 管道符 | 应用： ls -alh /bin | more 这个举例就相当于将 ls 将要显示的先放到 | 管道中，然后在more 调用管道内容。其他命题也可调用。

　

　　  ln -s 对象名 目标名 ：对目标建立软连接，删除对象，则连接失效。

　　  ln 对象名 目标名 ：对目标建立硬连接，删除对象，连接仍有效。

　　　　　　　　　　　　　　原理如图。

 

　　 grep "xxxx" xxx.txt ：grep 查找内容 查找目标，显示所有含有"xxxx"的。

　　 grep "xxxx" xxx.txt -n ：显示查找目标的行数。

　　 grep "xxxx" xxx.txt -v ：显示出，除含有"xxxx"以外的所有目标内容。

　　 grep "^xxxx" xxx.txt ：显示以"xxxx"开头的所有目标内容。

　　 grep "xxxx$" xxx.txt ：显示以"xxxx"结尾的所有目标内容。

 

　　find命令功能非常强大，通常用来在特定的目录下搜索符合条件的文件，也可以用来搜索特定用户属主的文件。而grep 是在文件内查找。

常用用法：

　　  find ./ -name test.sh ：查找当前目录下所有名为test.sh的文件。

　　 find ./ -name '*.sh' ：查找当前目录下所有后缀为.sh的文件。

　　 find ./ -name "[A-Z]*" ：查找当前目录下所有以大写字母开头的文件。

　　 find /tmp -size +2M ：查找在/tmp 目录下大于2M的文件。

　　 find ./ -size +4k -size -5M ：查找当前目录下大于4k，小于5M的文件。

　　 find ./ -perm 777 ：查找当前目录下权限为 777 的文件或目录。

 

　　通配符：通常通配符有?，*，[]。

　　　　　　 ls 2？ ：以“2”开头的并且唯一的提示。

　　　　　　 ls *2 ： 显示出以“2”开头的所有文件和文件夹。

　　　　　　 ls 1[123456]3.txt ：显示出所有113.txt,123.txt......

　　重定向：符号">"，">>"

　　　　　　 ls -alh > xxx.txt ：把即将显示到屏幕的内容保存到xxx.txt（覆盖原有数据）。

　　　　　　 ls -alh >> xxx.txt ：把即将显示到屏幕的内容保存到xxx.txt（以追加的方式）。

　　　　　

两个小快捷键分享：
　　1.　　首先进入“ctrl+alt+T”快捷进入终端。

　　2.　　可能会感觉字太小，按下“ctrl+shift” 再按 “+”放大字体，但是缩小字体是，按下“ctrl”再按“-”。

　　3.　　"ctrl+C"相当于不执行换行。再命令较长而且输入错误是方便使用。

 

-type类型可选参数为：  

| （1）b 块设备文件| （2）f 普通文件|  
| a|b|  

【Ubuntu Linux基本命令说明及使用 - yangyang222222222的博客 - CSDN博客】  
https://blog.csdn.net/yangyang222222222/article/details/79172463