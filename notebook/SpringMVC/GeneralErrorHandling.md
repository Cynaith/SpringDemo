### 通用错误处理
在Spring Boot中,Controller中抛出的异常交给了/error来处理,应用程序可以将/error映射到一个特定的Controller中处理来代替Spring Boot的默认实现,应用可以继承AbstractErrorController来统一处理系统的各种异常。
```java
    @Controller
    public class ErrorController extends AbstractErrorController {
        public ErrorController() {
            super(new DefaultErrorAttributes());
        }
        @RequestMapping("/error")
        public String getErrorPath() {
            //处理异常
            return "error.html";
        }
    }
```
AbstractErrorController提供了多个方法可以从request中获取错误信息,包含以下信息:
- **timestamp:** 错误发生的时间
- **status:** 对应于HTTP Status,如404
- **error:** 错误信息,如Bad Request、Not Found
- **exception:** 如果应用抛出有异常,exception是字符串,代表异常的类名
- **path:** 请求的URI
- **errors:** @Validated校验错误的时候,校验结果信息放至这里
