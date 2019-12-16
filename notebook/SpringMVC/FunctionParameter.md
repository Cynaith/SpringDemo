#### 方法参数
Spring Controller方法可以接受多种类型参数
- **[@PathVariable](#pathVariable):** 可以将URL中的值映射到方法参数中
- **[Model](#model和ModelAndView):** Spring中的通用MVC模型,也可以使用Map和ModelMap作为渲染视图的模型
- **[ModelAndView](#model和ModelAndView):** 包含了模型和视图路径的对象
- **[JavaBean](#javaBean接受HTTP参数):** 将HTTP参数映射到JavaBean对象 
- **[MultiPartFile](#MultipartFile):** 用于处理文件上传 
- **[@ModelAttribute](#modelAttribute):** 使用该注解的变量将作为Model的一个属性 
- **WebRequest或者NativeWebRequest:** 类似Servlet Request但做了一定封装。
- **java.io.InputStream和java.io.Reader:** 用来获取Servlet API中的InputStream/Reader  
- **java.io.OutputStream和java.io.Writer:** 用来获取Servlet API中的OutputStream/Writer
- **HttpMethod:** 枚举类型,对应于HTTP Method,如POST、GET
- **@MatrixVariable:** 矩阵变量  
- **[@RequestParam](#requestParam):** 对应于HTTP请求的参数,自动转化为参数对应的类型  
- **@RequestHeader:** 对应于HTTP请求头参数,自动转化为对应的类型 
- **[@RequestBody](#requestBody接受Json):** 自动将请求内容转化为指定的对象,默认使用HttpMessageConverters来转化 
- **@RequestPart:** 用于文件上传,对应于HTTP协议的multipart/form-data 
- **@SessionAttribute:** 该方法标注的变量来自于Session的属性 
- **@RequestAttribute:** 该标注的变量来自于request的属性 
- **[@InitBinder](#initBinder):**  用在方法上,说明这个方法会注册多个转化器,用来个性化地将HTTP请求参数转化成对应的Java对象,如转化为日期类型,浮点类型、javaBean等。也可实现WebBindingInitializer接口用于Spring Boot应用所需要的dataBinder。
- **BinderResult和Errors:** 用来处理数据绑定过程中的错误

---
##### @PathVariable
注解PathVariable用于请求url中获取参数并映射到方法参数中
```java
   @RequestMapping(value = "get/{id}.json")
    public @ResponseBody User getById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
``` 
 
---
##### Model和ModelAndView
任何MVC框架都有一个类似Map结构的Model,可以向Model添加视图需要的变量。Model对象有如下方法:
- **Model addAttribute(String attributeName,Object attributeValue):** 向模型添加一个变量
- **Model addAttribute(Object attributeValue):** 向模型添加一个变量,变量名字就是其类名首字母小写后转为的Java变量。
- **Model addAllAttributes(Map attributes):** 添加多个变量,如存在则<font color=#ff4911>覆盖</font>。
- **Model mergeAttributes(Map attributes):** 添加多个变量,如存在则<font color=#ff4911>忽略</font>。
- **Model addAllAttributes(Collection<?> attributeValues):** 添加多个变量,变量来自于集合的元素,命名规范同`Model addAttribute(Object attributeValue)`
- **boolean containsAttribute(String attributeName):** 判断是否存在变量

1. Model用于参数时,SpringMVC框架在调用方法前自动创建Model
2. ModelAndVie对象类似Model,但额外提供一个视图名称,也可在方法中构造
    
    ```java
    @GetMapping(path = "/{userId}/get.html")
    public ModelAndView getUSer(@PathVariable Long userId){
        ModelAndView view = new ModelAndView();
        view.setViewName("/userInfo.html");
        return view;
    }
    ```   
    
---
##### JavaBean接受HTTP参数

可以将HTTP参数转化为javaBean对象,HTTP参数的名字对应到POJO的属性名
  
    @GetMapping(path = "update.json")
    public User getUSer(User user){
        return user;
    }

---
##### @RequestParam
可以通过注解@RequestParam来进一步限定HTTP参数到Controller方法的映射关系,@RequestParam支持如下属性
- **value:** 指明HTTP参数的名称
- **required:** boolean类型,声明此参数是否必须有,如果HTTP参数里没有,则会抛出400错误
- **defaultValue:** 字符类型,如果HTTP参数没有提供,可以指定一个默认字符串,String类型转化为目标类型
---
##### @RequestBody接受Json
Controller方法带有@RequestBody注解的参数,意味着请求的HTTP消息体的内容是一个JSON,需要转化为注解指定的参数类型。Spring Boot默认使用Jackson来处理反序列化工作
    
        @GetMapping(path = "update.json")
        public User getUSer(@RequestBody User user){
                return user;
        }
---
##### MultipartFile
MultipartFile 提供以下方法来获取上传文件信息
- **getOriginalFilename:** 获取上传的文件名字
- **getBytes:** 获取上传文件内容,转为字节数组
- **getInputStream:** 获取一个InputStream
- **isEmpty:** 文件上传内容为空,或者就没有文件上传
- **getSize:** 文件上传大小
- **transferTo(File dest):** 保存上传文件到目标文件系统

如果同时上传多个图片,则使用MultipartFile数组类来接受多个文件上传:
```java
@PostMapping("/form")
public String handleFormUpload(String name,MultipartFile[] files) throws IOException{  
}
```
        
可以通过配置文件application.properties对Spring Boot上传的文件进行限定,默认为如下配置
```properties
    # 允许附件上传
    spring.servlet.multipart.enabled = true

    # 限定了当上传的文件超过一定长度时,就写到临时文件里.这有助于上传文件不占用过多内存(单位:MB/KB)
    spring.servlet.multipart.file-size-threshold = 0

    # location指的是临时文件的存放目录
    spring.servlet.multipart.location =

    # 指定了单个文件的最大长度,默认是1MB 
    spring.servlet.multipart.max-file-size = 1MB

    # 指定单次HTTP请求上传的最大长度,默认是10MB
    spring.servlet.multipart.max-request-size = 10MB

    # 表示当文件和参数被访问的时候再解析成文件
    spring.servlet.multipart.resolve-lazily = false
```
---
##### ModelAttribute
注解ModelAttribute通常作用在Controller的某个方法上,此方法会首先被调用,并将方法结果作为Model的属性,然后再调用对应的Controller处理方法
```java
    @ModelAttribute
    public void findUserById(@PathVariable Long id, Model model){
        model.addAttribute("user",userService.getUserById(id));
    }
    
    @GetMapping(path = "/{id}/get.json")
    @ResponseBody
    public String getUser(Model model){
        System.out.println(model.containsAttribute("user"));
        return "success";
    }
```
- 对于HTTP请求,/1/get.json会先调用findUserById()方法取得user,并添加到模型里。使用ModelAttribute通常可以用来向一个Controller中需要的公共模型添加数据。
- 如果findUserById仅仅添加一个对象到Model中,则可以改写成如下形式,相当于调用model.addAttribute(user)
    ```java
        @ModelAttribute
        public User findUserById(@PathVariable Long id){
            return userService.getUserById(id);
        }
    ```
---
##### @InitBinder
类似于Spring将HTTP参数绑定到JavaBean对象,Spring框架通过WebDataBinder类实现这种绑定,可以在Controller中用注解@InitBinder声明一个方法,来自己扩展绑定的特性
```java
import org.springframework.format.datetime.DateFormatter;import org.springframework.web.bind.WebDataBinder;import org.springframework.web.bind.annotation.InitBinder;import org.springframework.web.bind.annotation.RequestMapping;import org.springframework.web.bind.annotation.ResponseBody;@Controller
public class MyFormController{
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }
    
    @ResponseBody
    @RequestMapping("/date")
    public void printDate(Date d){
        System.out.println(d);
    }
}
```

    
    

  