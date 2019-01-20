## SAP S4 HANA
2019/1/10  
  在ubuntu上弄了好几天sap ecc，被折磨的快怀疑人生了。忽然发现已经是sap s4 hana时代了。本着要学就学最新技术的原则，果断开搞HANA。  

## SAP HANA是什么鬼
通常说到SAP，指的都是SAP Business Suite/R3(ECC) 这款产品。  

应用和技术两大类。其中应用方面的包括财务会计（FI）,管理会计（CO）,供应链管理-采购（MM），供应链管理-订单履行（SD）,供应链管理-计划（PP/APO-Planning）,人力资源（HR）,产品生命周期管理（PLM），项目管理(PS)等等;技术方面的课程包括ABAP开发（ABAP），Web AS实施与维护(BASIS)等等。

### SAP S/4 HANA与SAP R3不同点

  - 简单地说，S/4 HANA是下一代的R/3和SAP商务套件SAP。  
  - 它利用新的用户体验技术（SAP Fiori）和内存处理和数据库技术（SAP HANA），以及引入了一个新的引导配置的概念。  
  - 因此，它提高了简单，减少了处理时间，并提供比R/3更强大的功能。
  - **S/4hana重点是财务、ERP、CRM，SRM，SCM，PLM，和BW，与财务的组件组成的SAP新近发布的简单财务应用。**  

  - SAP R3基于任何的数据库（包括SAP HANA数据库），而SAP S/4 HANA是完全基于SAP HANA构建，优化了产品代码及数据结构，简化了财务流程和产品逻辑，并且应用了SAP Fiori新的用户交互系统。  
   
## SAP HANA构成
【官方安装文档解读SAP S4 HANA架构 - 刘欣的CSDN博客 - CSDN博客】https://blog.csdn.net/ot512csdn/article/details/74157410

## SAP HANA安装
不知道下面教程是否好用，晚上回家试试。  

### SAP S/4 HANA 1709 Fully Activated Appliance 安装文件/使用方法

  - SAP S/4 HANA 1709 Fully Activated Appliance(2017年10月版)   
   链接: https://pan.baidu.com/s/1pK8VuiR 密码: zi6d

  - SAP S/4 HANA 1709 FP1 Fully Activated Appliance (2018年5月版)  
   链接: https://pan.baidu.com/s/1I-fcsb1uLdpP5rkEAkET-A

   请注意这是官方安装文件，非VM虚拟机文件。

SAP S4HANA 1709 Fully Activated Appliance：简单来说比IDES版本功能更加强大，内置三个集团，分别用于测试不同业务。  
内置官方的BP内容 安装需要500G SSD   256 G物理内存  

### SAP论坛
http://www.itpub.net/forum.php?mod=forumdisplay&fid=45&filter=typeid&typeid=315


【华为 SAP HANA 一体机 RH5885H&RH8100 V3（Haswell+Redhat7.2）单机安装指南 07】　　
https://m.baidu.com/from=1099a/bd_page_type=1/ssid=0/uid=0/pu=sz%401320_480%2Ccuid%4060701D8D6CF190A5E8B52420690259097447DFB64FMFABSSDEA%2Ccua%40750_1334_iphone_10.12.0.13_0%2Ccut%40iPhone9%252C1_12.1.2%2Cosname%40baiduboxapp%2Cctv%401%2Ccfrom%401099a%2Ccsrc%40bdbox_tserch_txt%2Ccud%40MDhCNTY4NDItMTQ3Ri00NzA0LTgzMEItN0FBMDVEMDQxRDQx%2Cvmgdb%400020100228y%2Cta%40zbios_1_12.1_6_10.12%2Cusm%402/baiduid=AC48B59A4F678D17A384A88A17055F74/w=10_10_/t=zbios/l=3/tc?ref=www_zbios&lid=7717036730765331399&order=2&fm=alop&isAtom=1&is_baidu=0&tj=www_normal_2_10_10_title&vit=osres&m=8&srd=1&cltj=cloud_title&asres=1&title=SAPHANADATABASE%E5%AE%89%E8%A3%85-%E5%8D%8E%E4%B8%BASAPHANA%E4%B8%80%E4%BD%93%E6%9C%BARH...&dict=32&wd=&eqid=6b186c051fe8cc00100000065c36c03d&w_qd=IlPT2AEptyoA_yikHlKjDzZsOkkuqm2HFROF2SZZ0De&tcplug=1&sec=35547&di=e695723d5b1b9c31&bdenc=1&tch=124.0.277.261.0.0&nsrc=IlPT2AEptyoA_yixCFOxXnANedT62v3IFQ3FRS2GBnS7iEykffmlItdnJ7HNNXWCJlPdtmeRhAoDljrz3mRUjMsMu_9Spl6UaHzcd4zsgBW3GxY1fLM5OwLGSXNqpK&clk_type=1&l=1&baiduid=AC48B59A4F678D17A384A88A17055F74&w=10_10_ubuntu%20%E5%AE%89%E8%A3%85sap%20hana&t=zbios&from=1099a&ssid=0&uid=0&bd_page_type=1&pu=sz%401320_480%2Ccuid%4060701D8D6CF190A5E8B52420690259097447DFB64FMFABSSDEA%2Ccua%40750_1334_iphone_10.12.0.13_0%2Ccut%40iPhone9%252C1_12.1.2%2Cosname%40baiduboxapp%2Cctv%401%2Ccfrom%401099a%2Ccsrc%40bdbox_tserch_txt%2Ccud%40MDhCNTY4NDItMTQ3Ri00NzA0LTgzMEItN0FBMDVEMDQxRDQx%2Cvmgdb%400020100228y%2Cta%40zbios_1_12.1_6_10.12%2Cusm%402&clk_info=%7B%22srcid%22%3A1599%2C%22tplname%22%3A%22www_normal%22%2C%22t%22%3A1547092037964%2C%22xpath%22%3A%22div-article-header-div-a-h3%22%7D&sfOpen=1

【SAP S/4 1610 IDES + HANA 2.0 安装 - 江正军 - 博客园】  
https://www.cnblogs.com/jiangzhengjun/p/8150116.html

【Install HANA client on Ubuntu | SAP Blogs】  
https://blogs.sap.com/2012/09/14/install-hana-client-on-ubuntu/

【如何安装sap HANA studio并连接到学习机(91ABAP SAP HANA学习机)--开放的SAP HANA学习机 - BJ_CHENGRONG - CSDN博客】  
https://blog.csdn.net/bj_chengrong/article/details/72843532

【SAP HANA 部署指南_SAP HANA_SAP 解决方案_SAP 解决方案-阿里云】  
https://help.aliyun.com/document_detail/57229.html