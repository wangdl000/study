## MySql設定手順
### MySQLのインストールファイルはmsiとzipの２種類があります。今回はmsiを使います。  

### 1．MySQLダウンロード  
  - URL：
  http://dev.mysql.com/downloads/windows/installer/5.7.html
### ・以下の画像よりMySQL（オフラインでインストールのバージョン）をダウンロードする。  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/00_download.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/00_file.PNG)  

### 2．MySQLインストール  
mysql-installer-community-5.7.15.0.msiをインストールする。  
![310_01](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install01.PNG)  
![310_02](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install02.PNG)  
![310_03](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install03.PNG)  
![310_04](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install04.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install05.PNG)  
![310_06](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install06.PNG)  
![310_07](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install07.PNG)  
![310_08](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install08.PNG)  
![310_09](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install09.PNG)  
![310_10](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install10.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install11.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install12.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install13.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install14.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install15.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install16.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install17.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install18.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install19.PNG)  
![310_00](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/01_install20.PNG)  

### 3．DB作成  
以下の手順よりDBを作成する。  
  - 「CREATE DATABASE GELDB DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;」で「GELDB」というDBを作成する。  
![310_03](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/03_create1.PNG)  
![310_03](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/03_create2.PNG)  

### 4．DBツール(A5m2)ダウンロード  
  - URL
  http://www.vector.co.jp/download/file/winnt/business/fh675719.html
  - ・以下の画像よりDBツール(A5m2)をダウンロードする。  
![310_04](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/04_a5m2_01.PNG)  
![310_04](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/04_a5m2_02.PNG)  

### ５．MDB管理ツールの設定  
  - ダウンロードしたzipファイルをを「C:\pleiades\a5m2_2.11.6_x86」に解凍する。  

  - 以下の手順よりDBのテーブルを管理する。  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool1.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool2.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool3.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool4.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool5.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool6.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool7.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool8.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool9.PNG)  
![310_05](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/05_tool10.PNG)  

### ６．SQLでテーブルを作成する。  
  - 以下の画像より、スキーマを変更できる。  
  
![310_06](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/06_use1.PNG)  
    DROP TABLE IF EXISTS `GELDB`.`t_user`; 
    
    CREATE TABLE `GELDB`.`t_user` ( 
      `id` int (10) unsigned NOT NULL AUTO_INCREMENT COMMENT 'COMMENT'
      , `username` varchar (32) DEFAULT NULL COMMENT 'name'
      , `age` int (11) DEFAULT NULL COMMENT 'nenrei'
      , `gender` varchar (10) DEFAULT NULL COMMENT 'seibetu'
      , `birthday` varchar (64) DEFAULT NULL COMMENT 'birthday'
      , PRIMARY KEY (`id`)
    ) ENGINE = InnoDB DEFAULT CHARSET = utf8; 
  - 以下の画像より、スキーマを変更できる。  
![310_06](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/06_use2.PNG)  


### ７．DB接続する用のJARファイルをダウンロード  
  - ・URL
  http://dev.mysql.com/downloads/file/?id=465644
![310_07](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/07_dbjar1.PNG)  
![310_07](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mysql/07_dbjar2.PNG)  













