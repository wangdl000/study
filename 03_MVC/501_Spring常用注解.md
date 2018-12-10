## Spring常用注解  

### 使用注解来构造IoC容器  
用注解来向Spring容器注册Bean。需要在applicationContext.xml中注册<context:component-scan base-package=”pagkage1[,pagkage2,…,pagkageN]”/>。  

如：在base-package指明一个包  
   <context:component-scan base-package="cn.gacl.java"/>  

表明cn.gacl.java包及其子包中，如果某个类的头上带有特定的注解  【@Component/@Repository/@Service/@Controller】，就会将这个对象作为Bean注册进Spring容器。也可以在<context:component-scan base-package=” ”/>中指定多个包，如：  