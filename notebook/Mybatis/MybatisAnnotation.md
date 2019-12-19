### Mybatis注解开发
---
#### @Insert
- 不需要返回主键
- 返回自增主键
    - @Insert 中SQL除去 id 一列
    - 添加@Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    - <font color= #ff4911>**注:** 返回的主键id保存至对象实例中,insert操作只会返回受影响行数</font>
- 返回非自增主键
    - @SelectKey(statement = "SELECT LAST_INSERT_ID()",
        keyProperty = "id",
        resultType = Long.class,
        before = false)
---
#### Provider注解
- [动态SQL](https://github.com/Cynaith/SpringDemo/blob/master/notebook/Mybatis/DynamicSQL.md)