## Mybatis快速入门  
## 目录  
> 持久层（DAO层）  
> 一、Mybatis介绍  
> 二、mybatis快速入门  
> 三、数据库CRUD操作是什么  
> 四、使用MyBatis对表执行CRUD操作——基于XML的实现  
> 五、使用MyBatis对表执行CRUD操作——基于注解的实现  
> 六、利用mybatis-generator自动生成代码  

### 持久层（DAO层）  
  https://github.com/wangdl000/study/blob/master/03_MVC/318_%E6%8C%81%E4%B9%85%E5%B1%82%EF%BC%88DAO%E5%B1%82%EF%BC%89.md

  - 常见以下四种框架实现持久层  
    - JDBC  
    【JDBC 实现数据持久层框架】  
    https://www.cnblogs.com/jjh-java/p/6586795.html  

    - Mybatis 
    - Hibernate  
    - OpenJPA  

## 一、Mybatis介绍
　
　MyBatis是一个支持普通SQL查询，存储过程和高级映射的优秀持久层框架。  
  MyBatis消除了几乎所有的JDBC代码和参数的手工设置以及对结果集的检索封装。  
  MyBatis可以使用简单的XML或注解用于配置和原始映射，将接口和Java的POJO（Plain Old Java Objects，普通的Java对象）映射成数据库中的记录。

## 二、mybatis快速入门
### 2.1、准备开发环境

#### 1、创建测试项目，普通java项目或者是JavaWeb项目均可，如下图所示：

　　![601](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mybatis/601_211.png)  

#### 2、添加相应的jar包

　　【mybatis】  

       　　mybatis-3.1.1.jar

　　【MYSQL驱动包】  
　　　　mysql-connector-java-5.1.7-bin.jar
　　
　　![601](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mybatis/601_212.png)  

#### 3、创建数据库和表，针对MySQL数据库  

　　SQL脚本如下：

     create database mybatis;
     use mybatis;
     CREATE TABLE users(id INT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(20), age INT);
     INSERT INTO users(NAME, age) VALUES('孤傲苍狼', 27);
     INSERT INTO users(NAME, age) VALUES('白虎神皇', 27);

　　将SQL脚本在MySQL数据库中执行，完成创建数据库和表的操作，如下：
   ![601](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mybatis/601_213.png)  
　　

　　到此，前期的开发环境准备工作全部完成。

### 2.2、使用MyBatis查询表中的数据  

#### 1、添加Mybatis的配置文件conf.xml  

　　在src目录下创建一个conf.xml文件，如下图所示：  
  ![601](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mybatis/601_221.png) 
　　

　　conf.xml文件中的内容如下：  


    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
    <configuration>
        <environments default="development">
            <environment id="development">
                <transactionManager type="JDBC" />
                <!-- 配置数据库连接信息 -->
                <dataSource type="POOLED">
                    <property name="driver" value="com.mysql.jdbc.Driver" />
                    <property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
                    <property name="username" value="root" />
                    <property name="password" value="XDP" />
                </dataSource>
            </environment>
        </environments>
        
    </configuration>

#### 2、定义表所对应的实体类，如下图所示：  

　![601](https://github.com/wangdl000/study/blob/master/03_MVC/resource_mybatis/601_221.png) 


　　User类的代码如下：


    package me.gacl.domain;
    
    /**
     * @author gacl
     * users表所对应的实体类
     */
    public class User {
    
        //实体类的属性和表的字段名称一一对应
        private int id;
        private String name;
        private int age;
    
        public int getId() {
            return id;
        }
    
        public void setId(int id) {
            this.id = id;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public int getAge() {
            return age;
        }
    
        public void setAge(int age) {
            this.age = age;
        }
    
        @Override
        public String toString() {
            return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
        }
    }

　　3、定义操作users表的sql映射文件userMapper.xml

　　创建一个me.gacl.mapping包，专门用于存放sql映射文件，在包中创建一个userMapper.xml文件，如下图所示：

　　

　　userMapper.xml文件的内容如下：


    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <!-- 为这个mapper指定一个唯一的namespace，namespace的值习惯上设置成包名+sql映射文件名，这样就能够保证namespace的值是唯一的
    例如namespace="me.gacl.mapping.userMapper"就是me.gacl.mapping(包名)+userMapper(userMapper.xml文件去除后缀)
     -->
    <mapper namespace="me.gacl.mapping.userMapper">
        <!-- 在select标签中编写查询的SQL语句， 设置select标签的id属性为getUser，id属性值必须是唯一的，不能够重复
        使用parameterType属性指明查询时使用的参数类型，resultType属性指明查询返回的结果集类型
        resultType="me.gacl.domain.User"就表示将查询结果封装成一个User类的对象返回
        User类就是users表所对应的实体类
        -->
        <!-- 
            根据id查询得到一个user对象
         -->
        <select id="getUser" parameterType="int" 
            resultType="me.gacl.domain.User">
            select * from users where id=#{id}
        </select>
    </mapper>

　　4、在conf.xml文件中注册userMapper.xml文件


    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
    <configuration>
        <environments default="development">
            <environment id="development">
                <transactionManager type="JDBC" />
                <!-- 配置数据库连接信息 -->
                <dataSource type="POOLED">
                    <property name="driver" value="com.mysql.jdbc.Driver" />
                    <property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
                    <property name="username" value="root" />
                    <property name="password" value="XDP" />
                </dataSource>
            </environment>
        </environments>
        
        <mappers>
            <!-- 注册userMapper.xml文件， 
            userMapper.xml位于me.gacl.mapping这个包下，所以resource写成me/gacl/mapping/userMapper.xml-->
            <mapper resource="me/gacl/mapping/userMapper.xml"/>
        </mappers>
        
    </configuration>

　　5、编写测试代码：执行定义的select语句

　　创建一个Test1类，编写如下的测试代码：


    package me.gacl.test;
    
    import java.io.IOException;
    import java.io.InputStream;
    import java.io.Reader;
    import me.gacl.domain.User;
    import org.apache.ibatis.io.Resources;
    import org.apache.ibatis.session.SqlSession;
    import org.apache.ibatis.session.SqlSessionFactory;
    import org.apache.ibatis.session.SqlSessionFactoryBuilder;
    
    public class Test1 {
    
        public static void main(String[] args) throws IOException {
            //mybatis的配置文件
            String resource = "conf.xml";
            //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
            InputStream is = Test1.class.getClassLoader().getResourceAsStream(resource);
            //构建sqlSession的工厂
            SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
            //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
            //Reader reader = Resources.getResourceAsReader(resource); 
            //构建sqlSession的工厂
            //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
            //创建能执行映射文件中sql的sqlSession
            SqlSession session = sessionFactory.openSession();
            /**
             * 映射sql的标识字符串，
             * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
             * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
             */
            String statement = "me.gacl.mapping.userMapper.getUser";//映射sql的标识字符串
            //执行查询返回一个唯一user对象的sql
            User user = session.selectOne(statement, 1);
            System.out.println(user);
        }
    }

　　执行结果如下：

　　

　　可以看到，数据库中的记录已经成功查询出来了。

## 三、数据库CRUD操作是什么  
  CRUD操作（create 添加数据read读取数据 update 修改数据delete删除数据）。  

## 四、使用MyBatis对表执行CRUD操作——基于XML的实现  

1、定义sql映射xml文件

　　userMapper.xml文件的内容如下：


    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
    <!-- 为这个mapper指定一个唯一的namespace，namespace的值习惯上设置成包名+sql映射文件名，这样就能够保证namespace的值是唯一的
    例如namespace="me.gacl.mapping.userMapper"就是me.gacl.mapping(包名)+userMapper(userMapper.xml文件去除后缀)
     -->
    <mapper namespace="me.gacl.mapping.userMapper">
        <!-- 在select标签中编写查询的SQL语句， 设置select标签的id属性为getUser，id属性值必须是唯一的，不能够重复
        使用parameterType属性指明查询时使用的参数类型，resultType属性指明查询返回的结果集类型
        resultType="me.gacl.domain.User"就表示将查询结果封装成一个User类的对象返回
        User类就是users表所对应的实体类
        -->
        <!-- 
            根据id查询得到一个user对象
         -->
        <select id="getUser" parameterType="int" 
            resultType="me.gacl.domain.User">
            select * from users where id=#{id}
        </select>
        
        <!-- 创建用户(Create) -->
        <insert id="addUser" parameterType="me.gacl.domain.User">
            insert into users(name,age) values(#{name},#{age})
        </insert>
        
        <!-- 删除用户(Remove) -->
        <delete id="deleteUser" parameterType="int">
            delete from users where id=#{id}
        </delete>
        
        <!-- 修改用户(Update) -->
        <update id="updateUser" parameterType="me.gacl.domain.User">
            update users set name=#{name},age=#{age} where id=#{id}
        </update>
        
        <!-- 查询全部用户-->
        <select id="getAllUsers" resultType="me.gacl.domain.User">
            select * from users
        </select>
        
    </mapper>

　　单元测试类代码如下：


    package me.gacl.test;
    
    import java.util.List;
    import me.gacl.domain.User;
    import me.gacl.util.MyBatisUtil;
    import org.apache.ibatis.session.SqlSession;
    import org.junit.Test;
    
    public class TestCRUDByXmlMapper {
    
        @Test
        public void testAdd(){
            //SqlSession sqlSession = MyBatisUtil.getSqlSession(false);
            SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
            /**
             * 映射sql的标识字符串，
             * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
             * addUser是insert标签的id属性值，通过insert标签的id属性值就可以找到要执行的SQL
             */
            String statement = "me.gacl.mapping.userMapper.addUser";//映射sql的标识字符串
            User user = new User();
            user.setName("用户孤傲苍狼");
            user.setAge(20);
            //执行插入操作
            int retResult = sqlSession.insert(statement,user);
            //手动提交事务
            //sqlSession.commit();
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            sqlSession.close();
            System.out.println(retResult);
        }
        
        @Test
        public void testUpdate(){
            SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
            /**
             * 映射sql的标识字符串，
             * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
             * updateUser是update标签的id属性值，通过update标签的id属性值就可以找到要执行的SQL
             */
            String statement = "me.gacl.mapping.userMapper.updateUser";//映射sql的标识字符串
            User user = new User();
            user.setId(3);
            user.setName("孤傲苍狼");
            user.setAge(25);
            //执行修改操作
            int retResult = sqlSession.update(statement,user);
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            sqlSession.close();
            System.out.println(retResult);
        }
        
        @Test
        public void testDelete(){
            SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
            /**
             * 映射sql的标识字符串，
             * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
             * deleteUser是delete标签的id属性值，通过delete标签的id属性值就可以找到要执行的SQL
             */
            String statement = "me.gacl.mapping.userMapper.deleteUser";//映射sql的标识字符串
            //执行删除操作
            int retResult = sqlSession.delete(statement,5);
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            sqlSession.close();
            System.out.println(retResult);
        }
        
        @Test
        public void testGetAll(){
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            /**
             * 映射sql的标识字符串，
             * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
             * getAllUsers是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
             */
            String statement = "me.gacl.mapping.userMapper.getAllUsers";//映射sql的标识字符串
            //执行查询操作，将查询结果自动封装成List<User>返回
            List<User> lstUsers = sqlSession.selectList(statement);
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            sqlSession.close();
            System.out.println(lstUsers);
        }
    }

## 五、使用MyBatis对表执行CRUD操作——基于注解的实现  

　1、定义sql映射的接口

　　UserMapperI接口的代码如下：


    package me.gacl.mapping;
    
    import java.util.List;
    import me.gacl.domain.User;
    import org.apache.ibatis.annotations.Delete;
    import org.apache.ibatis.annotations.Insert;
    import org.apache.ibatis.annotations.Select;
    import org.apache.ibatis.annotations.Update;
    
    /**
     * @author gacl
     * 定义sql映射的接口，使用注解指明方法要执行的SQL
     */
    public interface UserMapperI {
    
        //使用@Insert注解指明add方法要执行的SQL
        @Insert("insert into users(name, age) values(#{name}, #{age})")
        public int add(User user);
        
        //使用@Delete注解指明deleteById方法要执行的SQL
        @Delete("delete from users where id=#{id}")
        public int deleteById(int id);
        
        //使用@Update注解指明update方法要执行的SQL
        @Update("update users set name=#{name},age=#{age} where id=#{id}")
        public int update(User user);
        
        //使用@Select注解指明getById方法要执行的SQL
        @Select("select * from users where id=#{id}")
        public User getById(int id);
        
        //使用@Select注解指明getAll方法要执行的SQL
        @Select("select * from users")
        public List<User> getAll();
    }

　　需要说明的是，我们不需要针对UserMapperI接口去编写具体的实现类代码，这个具体的实现类由MyBatis帮我们动态构建出来，我们只需要直接拿来使用即可。

　　2、在conf.xml文件中注册这个映射接口


    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
    <configuration>
        <environments default="development">
            <environment id="development">
                <transactionManager type="JDBC" />
                <!-- 配置数据库连接信息 -->
                <dataSource type="POOLED">
                    <property name="driver" value="com.mysql.jdbc.Driver" />
                    <property name="url" value="jdbc:mysql://localhost:3306/mybatis" />
                    <property name="username" value="root" />
                    <property name="password" value="XDP" />
                </dataSource>
            </environment>
        </environments>
        
        <mappers>
            <!-- 注册userMapper.xml文件， 
            userMapper.xml位于me.gacl.mapping这个包下，所以resource写成me/gacl/mapping/userMapper.xml-->
            <mapper resource="me/gacl/mapping/userMapper.xml"/>
            <!-- 注册UserMapper映射接口-->
            <mapper class="me.gacl.mapping.UserMapperI"/>
        </mappers>
        
    </configuration>

　　单元测试类的代码如下：


    package me.gacl.test;
    
    import java.util.List;
    import me.gacl.domain.User;
    import me.gacl.mapping.UserMapperI;
    import me.gacl.util.MyBatisUtil;
    import org.apache.ibatis.session.SqlSession;
    import org.junit.Test;
    
    public class TestCRUDByAnnotationMapper {
    
        @Test
        public void testAdd(){
            SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
            //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
            UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
            User user = new User();
            user.setName("用户xdp");
            user.setAge(20);
            int add = mapper.add(user);
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            sqlSession.close();
            System.out.println(add);
        }
        
        @Test
        public void testUpdate(){
            SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
            //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
            UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
            User user = new User();
            user.setId(3);
            user.setName("孤傲苍狼_xdp");
            user.setAge(26);
            //执行修改操作
            int retResult = mapper.update(user);
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            sqlSession.close();
            System.out.println(retResult);
        }
        
        @Test
        public void testDelete(){
            SqlSession sqlSession = MyBatisUtil.getSqlSession(true);
            //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
            UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
            //执行删除操作
            int retResult = mapper.deleteById(7);
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            sqlSession.close();
            System.out.println(retResult);
        }
        
        @Test
        public void testGetUser(){
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
            UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
            //执行查询操作，将查询结果自动封装成User返回
            User user = mapper.getById(8);
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            sqlSession.close();
            System.out.println(user);
        }
        
        @Test
        public void testGetAll(){
            SqlSession sqlSession = MyBatisUtil.getSqlSession();
            //得到UserMapperI接口的实现类对象，UserMapperI接口的实现类对象由sqlSession.getMapper(UserMapperI.class)动态构建出来
            UserMapperI mapper = sqlSession.getMapper(UserMapperI.class);
            //执行查询操作，将查询结果自动封装成List<User>返回
            List<User> lstUsers = mapper.getAll();
            //使用SqlSession执行完SQL之后需要关闭SqlSession
            sqlSession.close();
            System.out.println(lstUsers);
        }
    }

　　用到的MyBatisUtil工具类代码如下：


    package me.gacl.util;
    
    import java.io.InputStream;
    
    import org.apache.ibatis.session.SqlSession;
    import org.apache.ibatis.session.SqlSessionFactory;
    import org.apache.ibatis.session.SqlSessionFactoryBuilder;
    
    public class MyBatisUtil {
    
        /**
         * 获取SqlSessionFactory
         * @return SqlSessionFactory
         */
        public static SqlSessionFactory getSqlSessionFactory() {
            String resource = "conf.xml";
            InputStream is = MyBatisUtil.class.getClassLoader().getResourceAsStream(resource);
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            return factory;
        }
        
        /**
         * 获取SqlSession
         * @return SqlSession
         */
        public static SqlSession getSqlSession() {
            return getSqlSessionFactory().openSession();
        }
        
        /**
         * 获取SqlSession
         * @param isAutoCommit 
         *         true 表示创建的SqlSession对象在执行完SQL之后会自动提交事务
         *         false 表示创建的SqlSession对象在执行完SQL之后不会自动提交事务，这时就需要我们手动调用sqlSession.commit()提交事务
         * @return SqlSession
         */
        public static SqlSession getSqlSession(boolean isAutoCommit) {
            return getSqlSessionFactory().openSession(isAutoCommit);
        }
    }


### 六、利用mybatis-generator自动生成代码  

mybatis-generator有三种用法：命令行、eclipse插件、maven插件。个人觉得maven插件最方便，可以在eclipse/intellij idea等ide上可以通用。

下面是从官网上的截图：(不过官网www.mybatis.org 最近一段时间,好象已经挂了)



1、在pom.xml中添加plugin



    <plugin>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>1.3.2</version>
        <configuration>
            <configurationFile>src/main/resources/mybatis-generator/generatorConfig.xml</configurationFile>
            <verbose>true</verbose>
            <overwrite>true</overwrite>
        </configuration>
        <executions>
            <execution>
                <id>Generate MyBatis Artifacts</id>
                <goals>
                    <goal>generate</goal>
                </goals>
            </execution>
        </executions>
        <dependencies>
            <dependency>
                <groupId>org.mybatis.generator</groupId>
                <artifactId>mybatis-generator-core</artifactId>
                <version>1.3.2</version>
            </dependency>
        </dependencies>
    </plugin>

其中generatorConfig.xml的位置，大家根据实际情况自行调整

2、generatorConfig.xml配置文件


    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE generatorConfiguration
            PUBLIC "-//mybatis.org//DTD MyBatis Generator Configuration 1.0//EN"
            "http://mybatis.org/dtd/mybatis-generator-config_1_0.dtd">
    
    <generatorConfiguration>
        <classPathEntry
                location="C:/Oracle/Middleware/wlserver_10.3/server/lib/ojdbc6.jar"/>
        <context id="my" targetRuntime="MyBatis3">
            <commentGenerator>
                <property name="suppressDate" value="false"/>
                <property name="suppressAllComments" value="true"/>
            </commentGenerator>
    
            <jdbcConnection driverClass="oracle.jdbc.driver.OracleDriver"
                            connectionURL="jdbc:oracle:thin:@172.20.16.***:1521:CARGO" userId="***"
                            password="***"/>
    
            <javaModelGenerator targetPackage="ctas.test.entity"
                                targetProject="D:/yangjm/Code/CTAS/JAVAEE/CTAS2CCSP/src/main/java">
                <property name="enableSubPackages" value="true"/>
                <property name="trimStrings" value="true"/>
            </javaModelGenerator>
    
            <sqlMapGenerator targetPackage="ctas.test.entity.xml"
                             targetProject="D:/yangjm/Code/CTAS/JAVAEE/CTAS2CCSP/src/main/java">
                <property name="enableSubPackages" value="true"/>
            </sqlMapGenerator>
    
            <javaClientGenerator targetPackage="ctas.test.mapper"
                                 targetProject="D:/yangjm/Code/CTAS/JAVAEE/CTAS2CCSP/src/main/java" type="XMLMAPPER">
                <property name="enableSubPackages" value="true"/>
            </javaClientGenerator>
    
            <!--<table tableName="T_FEE_AGTBILL" domainObjectName="FeeAgentBill"
                   enableCountByExample="false" enableUpdateByExample="false"
                   enableDeleteByExample="false" enableSelectByExample="false"
                   selectByExampleQueryId="false"/>-->
    
            <table tableName="CTAS_FEE_BASE" domainObjectName="FeeBase"
                   enableCountByExample="false" enableUpdateByExample="false"
                   enableDeleteByExample="false" enableSelectByExample="false"
                   selectByExampleQueryId="false">
                <!--<columnRenamingRule searchString="^D_"
                                    replaceString=""/>-->
            </table>
    
        </context>
    </generatorConfiguration>

  -  几个要点：  
    - a) 因为生成过程中需要连接db，所以第3行指定了驱动jar包的位置  

    - b) 15-17行为连接字符串  

    - c) 19-33行指定生成“entity实体类、mybatis映射xml文件、mapper接口”的具体位置  

    - d) 40-46行为具体要生成的表，如果有多个表，复制这一段，改下表名即可  

 

### 3、使用方式

mvn mybatis-generator:generate

如果是在intellij 环境，直接鼠标点击即可



 

最后给出目录结构图：



最后给一些小技巧：

a) 建表时，字段名称建议用"_"分隔多个单词，比如:AWB_NO、REC_ID...，这样生成的entity，属性名称就会变成漂亮的驼峰命名，即：awbNo、recId

b)oracle中，数值形的字段，如果指定精度，比如Number(12,2)，默认生成entity属性是BigDecimal型 ，如果不指定精度，比如:Number(9)，指默认生成的是Long型

c)oracle中的nvarchar/nvarchar2，mybatis-generator会识别成Object型，建议不要用nvarchar2，改用varchar2

参考资料：  
https://dwz.cn/mwCH0hOz

https://www.cnblogs.com/xdp-gacl/p/4261895.html  

https://www.cnblogs.com/xdp-gacl/p/4262895.html

https://www.cnblogs.com/yjmyzz/p/mybatis-generator-tutorial.html

https://blog.csdn.net/lgslgs123456/article/details/47184017