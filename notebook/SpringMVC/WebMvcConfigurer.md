### WebMvcConfigurer

WebMvcConfigurer是用来全局定制化Spring Boot的MVC特性,开发者通过实现WebMvcConfigurer接口来配置应用的MVC全局特性。

- 拦截器(addInterceptors)
- 跨域访问配置(addCorsMappings)
- 格式化(addFormatters)
- URI到视图的映射(addViewControllers)

---
##### 拦截器
通过addInterceptors方法可以设置多个拦截器,比如对特定的URI设定拦截器以检查用户是否登陆,打印处理用户请求耗费的时间等。
```java
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(testInterceptor).addPathPatterns("/**").excludePathPatterns("/login/**");
        super.addInterceptors(registry);
    }
    
    class TestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");//Controller方法处理完毕后,调用此方法
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion");//页面渲染完毕后调用此方法,通常用来清除某些资源
    }

}
```

---
##### 跨域访问
出于安全的考虑,浏览器会禁止Ajax访问不同域的地址。
Spring Boot提供了对CORS的支持,可以实现addCorsMappings接口来添加特定的配置
```java
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**");
    }
```
更加精细的控制
```java
    protected void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://domain.com")
                .allowedMethods("POST","GET");
    }
```

---
##### 格式化
将HTTP请求映射到Controller方法的参数上后,Spring会自动进行类型转化。对于日期类型的参数,Spring默认并没有配置如何将字符串转为日期类型。为了支持可按照指定格式转为日期类型,需要添加一个DateFormatter类
```java
    protected void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd HH:mm:ss"));
    }
```

---
##### 注册Controller
应用有时候没有必要为一个URL指定一个Controller方法,可以直接将URI请求转到对模版的渲染上
```java
    protected void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index.html").setViewName("/index.btl");
        registry.addRedirectViewController("/**/*.do","/index.html");
    }
```
对于index.html的请求,设置返回的视图为index.btl
所有以.do结尾的请求重定向到/index.html请求

