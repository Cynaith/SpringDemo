### Mybatis缓存
---
* 一级缓存
    * 启动类添加注解`@EnableCaching`
    * 准备开启缓存的类上加`@Cacheable(cacheNames = "dm",key = "#dynamicTable.key1") `
        * 名字为dm的缓存
        * Spring Cache缓存了一个key为方法参数
* 二级缓存
    * 在Mapper上加`@CacheNamespace`注解
    * 启动类添加注解`@EnableCaching`或配置文件`mybatis.configuration.cache-enabled = true `
---
- 二级缓存缺点(使用Redis的原因)
    - 分布式环境下必然会出现脏数据
    - 多表联合查询的情况下极大可能会出现脏数据