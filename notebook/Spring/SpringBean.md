## Spring Bean

### Bean实例化的方式

* 使用类的无参构造函数创建
   ```xml
   <bean id="user" class="cn.itcast.ioc.User" ></bean>
   ```
* 使用静态工厂创建
   ```java
       public class BeanFactory {
            //静态的方法，返回Bean对象
            public static Bean getBean() {
                return new Bean();
            }
        }
   ```
   ```xml
   <!-- 使用静态工厂创建对象 -->
    <bean id="bean" class="cn.itcast.bean.BeanFactory" factory-method="getBean"></bean> 
   ```
   
* 使用实例工厂创建
    ```java
        public class BeanFactory {

        //普通的方法，返回Bean3对象
            public Bean getBean() {
                return new Bean();
            }
        }
    ```
    ```xml
        <!-- 使用实例工厂创建对象 -->
        <!-- 创建工厂对象 -->
        <bean id="beanFactory" class="cn.itcast.bean.BeanFactory"></bean>
        <bean id="bean" factory-bean="beanFactory" factory-method="getBean"></bean>
    ```
---
### Bean标签常用属性
- **id:** 起名字,根据id值找到配置的对象,不能包含特殊符号
- **class:** 创建对象所在类的全路径
- ~~**name:** 功能和id一样,可以使用特殊符号~~
- **scope:** 
    * **singleton:** 默认值,单例
    * **prototype:** 多例
    * **request:** 创建对象把对象放进request域里
    * **session:** 创建对象把对象放进session域里
    * **globalSession:** 创建对象把对象放进globalSession域里
  
---
### 属性注入
创建对象时,向对象属性里面设置值
- 属性注入方式
    - 使用set方法注入
        ```xml
            <bean id="xiaohua" class="com.ly.springdemo.Spring.Bean1">
            <property name="id" value="2"></property>
            <property name="name" value="xiaohua"></property>
            </bean>
        ```
        **ref:** 引用对象
        **value:** 字符串
        ```java
        public class Bean1 {
            String name;
            int id;
         }
        ```
        ```java
            ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
            Bean1 xiaohua= (Bean1) applicationContext.getBean("xiaohua");
            System.out.println(xiaohua.toString());
        ```
    - 使用有参构造函数注入
        ```xml
            <bean id="xiaoming" class="com.ly.springdemo.Spring.Bean1">
            <constructor-arg name="id" value="1"></constructor-arg>
            <constructor-arg name="name" value="xiaoming"></constructor-arg>
            </bean>
        ```
       
    - 使用接口注入(Spring不支持)

-  注入对象类型属性
    ```xml
        <bean id="userDao" class="com.ly.springdemo.Spring.UserDao"></bean>
        <bean id="userService" class="com.ly.springdemo.Spring.UserService">
        <property name="userDao" ref="userDao"></property>
        </bean>
    ``` 
    [UserService.java](https://github.com/Cynaith/SpringDemo/tree/master/src/main/java/com/ly/springdemo/Spring/UserService.java)<br>
    [UserDao.java](https://github.com/Cynaith/SpringDemo/tree/master/src/main/java/com/ly/springdemo/Spring/UserDao.java)   
- 注入复杂类型属性
    ```xml
        <bean id="setComplexType" class="com.ly.springdemo.Spring.SetComplexType">
        <property name="arr">
            <list>
                <value>123</value>
                <value>2133</value>
            </list>
        </property>
        <property name="list">
            <list>
                <value>xiaoming</value>
                <value>xiaohua</value>
            </list>
        </property>
        <property name="map">
            <map>
                <entry key="name" value="xiaoming"></entry>
                <entry key="name1" value="xiaohua"></entry>
            </map>
        </property>
        <property name="properties">
            <props>
                <prop key="driverclass">com.mysql.jdbc.driver</prop>
                <prop key="username">root</prop>
                <prop key="password">admin</prop>
            </props>
        </property>
        </bean>
    ```
    [SetComplexType.java](https://github.com/Cynaith/SpringDemo/tree/master/src/main/java/com/ly/springdemo/Spring/SetComplexType.java)<br>
    [SpringTest.java](https://github.com/Cynaith/SpringDemo/tree/master/src/main/java/com/ly/springdemo/Spring/SpringTest.java)
    