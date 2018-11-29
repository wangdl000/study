## 文件管理软件SVN和GitHub  

  - 【GitHub和SVN的区别】  
http://blog.csdn.net/Peter_tang6/article/details/76577108
 - **SVN commit后文件已经在文件服务器上了，GitHub commit后还要push，才能将文件提交到文件服务器上**  
 - 
 - **本次课程用GitHub管理Java代码和文件**  
 - **以下安装配置步骤中日文混入，原谅我偷个懒**  
### 前提  
你需要一个邮箱，用邮箱地址申请GitHub账户。略  

### GitHub安装配置  
#### 1、Git安装教程（Windows安装超详细教程）  
 - **下载地址**   
https://gitforwindows.org/
 - **安装步骤** 
 无耻的盗用别人的图片  
    - 下载（Git-2.19.2-64-bit.exe）  
![410_01](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/00_download.PNG)  
    - 1.开始安装  
![410_02](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/01_start.PNG)  
    - 2.安装路径  
![410_03](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/02_path.PNG)  
    - 3.选择安装组件（默认）  
![410_04](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/03_com.PNG)  
    - 4.菜单文件夹（默认）  
![410_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/04_menu.png)  
    - 5.修改系统的环境变量（选第一个）
![410_06](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/05_environment.png)  
    - 6.SSL的证书的选择  
![410_07](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/06_ssl.png)  
    - 7.配置行尾结束符（默认）  
![410_08](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/07_config.png)  

#### 2、TortoiseGitのインストール方法  
 - **请参照如下地址**    
 - **需要安装的文件有两个（TortoiseGit-2.7.0.0-64bit.msi，TortoiseGit-LanguagePack-2.7.0.0-64bit-ja.msi）**  
http://www.aise.ics.saitama-u.ac.jp/~gotoh/HowToInstallTortoiseGit.html#toc1

#### 3、使用方法  
  - 1.如下图任意空文件夹中鼠标右键，选择【Git クローン（複製）...】  
![410_20](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/20_use.png)  
  - 2.URL:「https://github.com/wangdl000/study.git」，  
  - ディレクトリ「**任意你想要指定的空文件夹**」  
![410_21](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/21_clone.png)  
  - 
![410_22](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/22_downloading.png)  
  - 
![410_23](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/23_complete.png)  
  - 3.提交（コミット）方法（需要权限）  
![410_24](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/24_commit.png)  
  - 4.提交文件选择和日志  
![410_25](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/25_comment.png)  
  - 5.PUSH（GitHub特有）  
![410_26](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/26_push.png)  
   
![410_27](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/27_push2.png)  
    
![410_28](https://github.com/wangdl000/study/blob/master/03_MVC/resource_410/28_commit_complete.png)  