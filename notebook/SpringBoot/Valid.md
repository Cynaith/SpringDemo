### 业务层校验
---
- **Validator+BindingResult**
    - 请求数据传递到接口时，Validator就自动完成校验，校验的结果封装在BindingResult中。
        ```java
        @RequestMapping("validOutput")
        public String validApiLearn(@RequestBody @Valid ApiLearn apiLearn, BindingResult bindingResult){
            for (ObjectError error:bindingResult.getAllErrors()){   
                return error.getDefaultMessage();
            }
            return apiLearn.toString();
        }
        ```
        ```java
        public class ApiLearn {
        @NotNull(message = "id不能为空")
        private int id;

        @NotNull(message = "账号不能为空")
        @Size(min = 6,max = 12,message = "账号长度必须是6-12个字符")
        private String account;

        @NotNull(message = "邮箱不能为空")
        @Email(message = "邮箱格式不正确")
        private String mail;

        @Max(value = 120,message = "年龄必须小于120")
        private int age;

        @AssertTrue(message = "字段为true才能通过")
        private boolean isPass;

        @Future(message = "时间在当前时间之后才可以通过")
        private Date futureDate;

        @Past(message = "时间在当前时间之前才可以通过")
        private Date passDate;
        }
        ```
- **Validator+自动抛出异常**
    - 新建一个类 在这个类上添加注解@ControllerAdvice或@RestControllerAdvice，借此这个类就配置成了全局处理类。<br/>
    然后在类中新建方法，方法上加上@ExceptionHandler注解，并指定你想处理的异常类型，接着在方法内编写对该异常的操作逻辑
        ```java
         /**
        * @ExceptionHandler里输入想要获取的异常
        * @param e
        * @return
        */
        @ExceptionHandler(MethodArgumentNotValidException.class)
        public String MethodArgumentNotValidEExceptionHandler(MethodArgumentNotValidException e){
            ObjectError error = e.getBindingResult().getAllErrors().get(0);
            return error.getDefaultMessage();
        }
        ```
