## Java環境構築
> #### *JDK1.8ダウンロード*
> #### *インストール*
> #### *バージョン確認*
> #### *環境変数設定*

## 詳細内容
### 1. JDK1.8ダウンロード（バージョン：Java SE Development Kit 8u181）
**[ダウンロードリンク](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)**    

-  下図よりJDKをダウンロードする。
    -  システムの種類は３２ ビットの場合、「jdk-8u181-windows-i586.exe」をダウンロードしてください。  
    -  ６４ビットの場合、「jdk-8u181-windows-x64.exe」をダウンロードしてください。  
![jdk download](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/01_download.PNG)    

- #### システムの種類の確認方法は下図を参照してください。  
     -  1) PC \> プロパティ(R) を選択する。  
![jdk download](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/01_01_pc_prop.png)    
     -  2) システムの種類を確認する。  
![jdk download](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/01_02_sys_type.png)    

### ２．インストール  
-  下図の順番通り、JDKをインストールする。  
    -  1)  
![インストール1](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/02_01_jdk_file.PNG)  
    -  2)  
![インストール2](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/02_02_conform.PNG)  
    -  3)  
![インストール3](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/002_03_next.PNG)  
    -  4)  
![インストール4](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/02_04_path.PNG)  
    -  5)  
![インストール5](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/02_05_installing.PNG)    
    -  6)  
![インストール6](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/02_06_jre_path.PNG)    
    -  7)  
![インストール7](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/02_07_jre_installing.PNG)    
    -  8)  
![インストール8](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/02_08_complete.PNG)    

### ３．バージョン確認
-  以下の命令でインストールしたJDKのバージョンを確認する。
    -  「java -version」  
-  「java version "1.8.0_181"」が表示されることを確認する。
![jdk download](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/03_01_jdk_version.PNG)    

### ４．環境変数設定
-  1) 以下の２つ環境変数を作成する。
    -  「JAVA_HOME=.;C:\Program Files\Java\jdk1.8.0_181」  
    -  「Path=%JAVA_HOME%\bin;」(※ 既存の内容を削除しないようにしてください。)  
-  2) 作成方法は下図を参照してください。  
    -  （Windows10）  
![環境変数0](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/04_01_JAVA_HOME.PNG)    
    -  （Windows7）  
![環境変数1](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/04_11.PNG)  
![環境変数2](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/04_12.PNG)  
![環境変数3](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/04_13.PNG)  
![環境変数4](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/04_14.PNG)  
![環境変数5](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/04_15.PNG)  
![環境変数6](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/04_16.PNG)  
![環境変数7](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/04_17.PNG)  
![環境変数8](https://github.com/wangdl000/study/blob/master/00_Java%E4%BA%8B%E5%89%8D/resource_jdk/04_18.PNG)    

## \>>>>>>    終わり <<<<<<<<

