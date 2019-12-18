### Mybatis 入门
---
- Spring Boot maven配置
    ```xml
        <!-- https://mvnrepository.com/artifact/org.mybatis.spring.boot/mybatis-spring-boot-starter -->
        <dependency>
            <groupId>org.mybatis.spring.boot</groupId>
            <artifactId>mybatis-spring-boot-starter</artifactId>
            <version>2.1.0</version>
        </dependency>

    ```
- Spring maven配置
    ```xml
        <!-- https://mvnrepository.com/artifact/org.mybatis/mybatis-spring -->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.0</version>
        </dependency>
    ```
    
- Spring Boot配置Mybatis
    - 配置log4j日志输出sql
        - maven配置最新log4j
            ```xml
                <!-- https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-log4j2 -->
                <dependency>
                    <groupId>org.springframework.boot</groupId>
                    <artifactId>spring-boot-starter-log4j2</artifactId>
                    <version>2.1.2.RELEASE</version>
                </dependency>
            ```
        - Spring Boot配置文件
            ```properties
                logging:
                    level:
                        #包名
                        com: 
                          ly:
                            springdemo:
                              Mapper: DEBUG
            ```
        - log4j配置文件 
            ```properties
                log4j.rootLogger=debug,CONSOLE,FILE
    
                ##输出到控制台
                log4j.appender.CONSOLE=org.apache.log4j.ConsoleAppender
                log4j.appender.CONSOLE.Threshold=DEBUG
                log4j.appender.CONSOLE.layout.ConversionPattern=%d{yyyy-MM-dd HH\:mm\:ss} -%-4r [%t] %-5p  %x - %m%n
                log4j.appender.CONSOLE.Target=System.out
                log4j.appender.CONSOLE.Encoding=gbk
                log4j.appender.CONSOLE.layout=org.apache.log4j.PatternLayout
      
                ##输出到日志文件 每10M分成一个日志文件
                #log4j.appender.FILE=org.apache.log4j.DailyRollingFileAppender
                #log4j.appender.FILE.File=/Users/dalaoyang/Downloads/log
                #log4j.appender.FILE.DatePattern = '_'yyyy-MM-dd-HH-mm'.log'
                #log4j.appender.FILE.MaxFileSize=10MB
                #log4j.appender.FILE.layout=org.apache.log4j.PatternLayout
                #log4j.appender.FILE.layout.ConversionPattern=%d%n%m%n
            ```
 