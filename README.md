### 基于SpringBoot的Spring SpringMVC Mybatis
---
### Spring 
* [思维导图](https://upload-images.jianshu.io/upload_images/1932449-7ad2dbd931446eaa.png?imageMogr2/auto-orient/strip|imageView2/2/w/1200/format/webp)
#### Spring IOC
   * **定义**
        * **控制反转:** 把对象的创建交给Spring管理,不使用new的方式,也不使用工厂模式 
   * **原理**
        * xml配置文件
        * dom4j解析xml文件
        * 工厂设计模式
        * 反射
   * **使用**
        * 配置文件方式
        * 注解方式
   * **[bean管理(使用对象)](https://github.com/Cynaith/SpringDemo/blob/master/notebook/Spring/SpringBean.md)** 
   * **IOC与DI区别**
        * **IOC:** <font color = #ff4911>控制反转</font>,把对象创建交给spring进行配置
        * **DI:** <font color = #ff4911>依赖注入</font>,向类里面的属性中设置值
        * **关系:** 依赖注入不能单独存在，需要在ioc基础之上完成操作
#### Spring AOP
* **定义**
    * **面向切面编程:** 采用横向抽取机制,代替了传统的纵向继承体系重复性代码,不需修改原代码,实现功能扩展
* **原理**
    * **动态代理**
        * **有接口:** 使用jdk动态代理
        * **无接口:** 使用cglib动态代理
* **[术语](https://github.com/Cynaith/SpringDemo/blob/master/notebook/Spring/SpringAopTerm.md)** 
* **[AOP操作](https://github.com/Cynaith/SpringDemo/tree/master/src/main/java/com/ly/springdemo/AOP)**
#### Spring的事务管理
* **特性**
    * **原子性:** 事务应该当作一个单独单元的操作,整个序列操作要么是成功的,要么是失败的
    * **一致性:** 表示数据库的引用完整性的一致性,表中唯一的主键等
    * **隔离型:** 可能同时处理很多有相同的数据集的事务,每个事务应当和其他事务隔离,以防止数据损坏
    * **持久性:** 一个事务一旦完成全部操作后,这个事务的结果必须是永久性的,不能因系统故障而从数据库删除
* **基本流程**
    ![流程图](notebook/img/shiwu.png)
* **事务隔离级别**
* **事务管理器**
* **类型**
    * 编程式事务
    * 声明式事务
    

---
#### Spring MVC
* [引入依赖](https://github.com/Cynaith/SpringDemo/blob/master/pom.xml)
* [URL映射到方法](https://github.com/Cynaith/SpringDemo/blob/master/notebook/SpringMVC/UrlToFunction.md)
* [方法参数](https://github.com/Cynaith/SpringDemo/blob/master/notebook/SpringMVC/FunctionParameter.md)
* [验证框架](https://github.com/Cynaith/SpringDemo/blob/master/notebook/SpringMVC/VerificationFramework.md)
* [WebMvcConfig](https://github.com/Cynaith/SpringDemo/blob/master/notebook/SpringMVC/WebMvcConfigure.md)
* [视图技术](https://github.com/Cynaith/SpringDemo/blob/master/notebook/SpringMVC/View.md)
* [通用错误处理](https://github.com/Cynaith/SpringDemo/blob/master/notebook/SpringMVC/GeneralErrorHandling.md)
* [@Service和Transactional](https://github.com/Cynaith/SpringDemo/blob/master/notebook/SpringMVC/ServiceAndTransactional.md)
* ~~curl命令~~


---
#### Mybatis



---
