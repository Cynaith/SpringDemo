### 术语
---
- **连接点JoinPoint:** Spring允许你通知的地方,每个方法前后都可以有,或抛出异常时都可以是连接点(spring只支持方法连接点) 
- **通知Advice:** 对切入点做的事情就是通知(前置、后置、异常、最终、环绕通知)
- **切入点Pointcut:** 要对哪些连接点进行拦截
- **切面Aspect:** 切入点和通知的结合
- **引入introduction:** 允许我们向现有的类添加新方法属性。这不就是把切面（也就是新方法属性：通知定义的）用到目标类中吗
- **目标对象target:** 代理的目标对象(增强方法所在的类)
- **代理proxy:** 一个类被AOP织入增强后,就会产生一个结果代理类
- **织入weaving:** 把通知应用到target的过程 