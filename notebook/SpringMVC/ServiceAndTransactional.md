### Service和Transactional
在Spring Boot中Controller 调用业务逻辑处理交给了被@Service注解的类

```java
    @Transactional(rollbackOn = Exception.class)
    public User createUser(User user) {
        userRepository.save(user);
        throw new RuntimeException();
    }
    
    @Transactional
    public User createUser(User user) {
        userRepository.save(user);
        throw new RuntimeException();
    }

    @Transactional(rollbackOn = Exception.class)
    public User createUser(User user) throws Exception {
        userRepository.save(user);
        throw new Exception();
    }
```

当Controller调用Service方法的时候,会开启一个事务上下文,随后的调用都将处于这个事务上下文中。如果调用这个Service方法抛出RuntimeException,事务会自动回滚。否则事务将提交。
