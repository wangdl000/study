## java 调用SAP RFC函数错误信息集锦

  RFC接口调用SAP如果有异常会通过com.sap.mw.jco.JCO$Exception: 抛出异常  

#### 在开发中遇到的异常有如下 
 
  - 用户名密码可能是错误或者用户无权限,确认用户,必要时联系SAP负责人,检查用户  
(103) RFC_ERROR_LOGON_FAILURE: ##.#####,####  
(103) RFC_ERROR_LOGON_FAILURE: Name or password is incorrect (repeat logon)  

  - call信息没有填写完整,检查配置文件各个SAP配置信息是否完整  
(101) RFC_ERROR_PROGRAM: Missing R3NAME=... or ASHOST=... in connect_param in RfcOpenEx  

  - ip地址失败：  
com.sap.mw.jco.JCO$Exception: (102) RFC_ERROR_COMMUNICATION: Connect to SAP gateway failed  

  - 组权限访问 server文件没更新.  
(102) RFC_ERROR_COMMUNICATION:Connect to message server failed  
C:\WINNT\system32\drivers\etc  

  - 端口号错误报错信息：
(103) RFC_ERROR_LOGON_FAILURE: ## 502 ########  

  - 超时:  
(103) RFC_ERROR_LOGON_FAILURE: Timeout  

  - 执行函数,函数的问题  
(104) RFC_ERROR_SYSTEM_FAILURE: Error in module RSQL of the database interface.执行函数  
(104) RFC_ERROR_SYSTEM_FAILURE: An error occurred when receiving a complex parameter.  
(106) JCO_ERROR_RESOURCE: Trying to access row values in a table which does not have any rows yet  

  - 返回的表没有值.那个表连第一行都没有,取不到  
(106) JCO_ERROR_RESOURCE: Trying to access row values in a table which does not have any rows yet  

  - 语法错误  
(104) RFC_ERROR_SYSTEM_FAILURE: Syntax error in program SAPMV50A  

  - 找不到行  
(106) JCO_ERROR_RESOURCE: Trying to access row values in a table which does not ha:ve any rows yet  

  - 输入参数不能插入SAP函数输入字段中.  
(122) JCO_ERROR_CONVERSION: Integer '4234243' has to many digits at field PO_ITEM  