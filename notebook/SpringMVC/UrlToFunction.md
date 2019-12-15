### URL映射到方法
---
#### @RequestMapping
RequestMapping有多个属性来进一步匹配HTTP请求到Controller方法
* **value:** 请求的URL路径,支持URL模版、正则表达式。
* **method:** HTTP请求方法,有GET、POST、PUT等。
* **consumes:** 允许的媒体类型(Media Types),如`consumes = "application/json"`,对应于请求的HTTP的Content-Type。 
* **produces:** 相应的媒体类型,如`produces = "application/json"`,对应于HTTP的Accept字段。
* **params:** 请求的参数,如`params = "action = update"。
* **headers:** 请求的HTTP头的值,如headers = "myHeader = myValue"。
#### URL路径映射
属性value用于匹配一个URL映射，value支持简单的表达式来匹配:
```java
   @RequestMapping(value = "get/{id}.json")
    public @ResponseBody User getById(@PathVariable("id") Long id){
        return userService.getUserById(id);
    }
```
---
#### Ant路径表达式
Ant用符号"*" 来表示匹配任意字符,用"**"来表示统配任意路径,用"?"来匹配单个字符,比如
- **`/user/*.html`:** 匹配/user/1.html、/user/2.html
- **`/**/1.html`:** 匹配/1.html,也匹配/user/1.html,还匹配/user/add/1.html
- **`/user/?.html`:** 匹配/user/1.html,但不匹配/user/11.html 

如果一个请求有多个@RequestMapping能够匹配,通常是更具体的匹配会作为处理此请求的方法
- 有通配符的低于没有通配符的,比如`/user/add.json`比`/user/*.json`优先匹配
- 有"**"通配符的低于有"*"通配符的
---
#### HTTP method匹配
@RequestMapping提供method属性来映射对应HTTP的请求方法,通常HTTP请求方法有如下方法
- **GET:** 用来获取URL对应内容
- **POST:** 用来向服务器提交信息
- **HEAD:** 同GET,但不返回消息体,通常用于返回URL对应的元信息,如过期时间等。搜索引擎通常用HEAD来获取网页信息
- **PUT:** 同POST,用来向服务器提交信息,但语义上更像一个更新操作。同一个数据PUT多次不会改变数据。
- **DELETE:** 删除对应资源信息
- **PATCH:** 类似PUT方法,表示信息的局部更新

Spring提供新注解来表示HTTP方法:
- @GetMapping/@PostMapping...
---
#### consumes和produces
##### consumes
属性consumes意味着请求的HTTP头的Content-Type媒体类型与consumes的值匹配,才能调用此方法
<br>常见的MediaType(媒体)类型如下
- **text/html:** HTML格式 
- **text/plain:** 纯文本格式 
- **text/xml:** XML格式
- **image/gif:** gif图片格式
- **image/jpeg:** jpg图片格式
- **image/png**:png图片格式 

以application开头的媒体格式类型如下
- **application/xhtml+xml:** XHTML格式
- **application/xml:** XML格式
- **application/atom+xml:** Atom XML聚合格式
- **application/json:** json格式
- **application/pdf:** pdf格式
- **application/msword:** Word文档格式
- **application/octet-stream:** 二进制流数据(常见的文件下载)

上传文件时
- **multipart/form-data:** 需要在表单中进行文件上传时，就需要使用该格式

##### produces
表示的指定返回MIME格式

---
#### params和header匹配
可以从请求参数或者HTTP头中提取值来进一步确定调用的方法,有以下三种格式
- 如果存在参数,则通过
- 如果不存在参数，则通过
- 如果参数等于某一个具体值,则通过

 



