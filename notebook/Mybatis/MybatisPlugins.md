### Mybatis插件
---
#### PageHelper
- 引入依赖
    ```xml
        <!-- https://mvnrepository.com/artifact/com.github.pagehelper/pagehelper-spring-boot-starter -->
        <dependency>
            <groupId>com.github.pagehelper</groupId>
            <artifactId>pagehelper-spring-boot-starter</artifactId>
            <version>1.2.10</version>
        </dependency>
    ```
- application.yml中配置
    ```properties
        # 分页配置
        pagehelper:
            helper-dialect: mysql
            reasonable: true
            support-methods-arguments: true
            params: count=countSql
    ```
- 或程序中配置
    ```java    
    @Configuration
    public class MybatisConfig {
    @Bean
    public PageHelper pageHelper() {
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("dialect", "Mysql");
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        pageHelper.setProperties(p);
        return pageHelper;
        }
    }
    ```
    注:应导入PageHelper包,而不是Spring Boot Starter包
- 代码实现
    ```java
        PageHelper.startPage(pageNum,pageSize);
        List<User> userList = userMapping.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(userList);
        return pageInfo;
    ```