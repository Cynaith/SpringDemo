### 验证框架
Spring Boot支持JSR-303、Bean验证框架,默认使用的是Hibernate validator。在SpringMVC中,只需要使用@Valid注解标注在方法参数上,Spring Boot即可对参数对象进行校验,校验结果放在BindingResult中

---
##### JSR-303
Java标准验证框架,已有的实现有Hibernate validator。JSR-303定义了一系列注解用来验证Bean的属性,常用的有如下几种.
* 空检查
    * **@Null:** 验证对象是否为空:
    * **@NotNull:** 验证对象不为空
    * **@NotBlank:** 验证字符串不为空或者不是空字符串,比如""和""都会验证失败
    * **@NotEmpty:** 验证对象不为null,或者集合不为空
* 长度检查
    * **@Size(min = ,max = ):** 验证对象长度,可支持字符串、集合
    * **@Length:** 字符串大小
* 数值检测
    * **@Min:** 验证数组是否大于等于指定的值
    * **@Max:** 验证数组是否小于等于指定的值
    * **@Digits:** 验证数字是否符合指定格式,如@Digits(integer = 9,fraction = 2)
    * **@Range:** 验证数字是否在指定的范围内,如@Range(min = 1,max = 1000)
* 其他
    * **@Email:** 验证是否为邮箱格式,为null则不做校验
    * **@Pattern:** 验证String对象是否符合正则表达式的规则

- 包含验证注解的JavaBean
    ```java
        public class WorkInfoForm{
            @NotNull
            Long id;
            @Size(min = 3,max = 20)
            String name;
            @Email
            String email;
        }
    ```

不同业务会有不同的验证逻辑,JSR-303定义了group概念
```java
    public class WorkInfoForm{
    //定义一个类,更新时校验组
        public interface Update{}
        public interface Add{} 
        @NotNull(group = {Update.class})
        @Null(group = {Add.class})
        Long id;
    }
```
表示当校验上下文为Add.class时,@Null生效,id为空才能校验通过

---
##### MVC中使用@Validated
在Controller中,只需要给方法参数加上@Validated即可触发一次校验
```java
    @ResponseBody
    @RequestMapping("/addworkinfo.html")
    public void addWorkInfo(@Validated({WorkInfoForm.Add.class}) WorkInfoForm workInfo,BindingResult result){
        if(result.hasErrors()){
            List<ObjectError> list = result.getAllErrors();
            FieldError error = (FieldError)list.get(0);
            System.out.println(error.getObjectName()+","+error.getField()+","+error.getDefaultMessage());
        }
        return ;
    } 
```

触发Spring校验,并将验证结果存放到BindingResult对象中。在示例代码中,Validated注解使用了校验的上下文WorkInfoForm.Add.Class 因此,整个校验将按照Add.class来校验
<br>
BindingResult包含了验证结果,提供了如下方法:
- **hasErrors:** 判断验证是否通过
- **getAllErrors:** 得到所有的错误信息,通常返回的是FieldError列表
