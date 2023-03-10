# 工程简介

> springboot版本为2.2.2.RELEASE,主要作用是为了研读 Springboot或Spring 源码执行逻辑

# 延伸阅读

## 常见问题
- 1.springboot启动流程是什么?
- 2.springboot项目中使用了哪些设计模式?
  - 观察者模式
  - 工厂模式
  - 单例模式(经典案例: DCL)
- 3.spring中父子容器有怎样作用?
- 4.spring中缓存包含一级、二级以及三级，分别有哪些作用? 三级缓存的作用是什么?
````javascript
 // singletonObjects --> 单例池，存放已经创建完成，并且属性也注入的对象!
 // earlySingletonObjects --> 提前暴露的对象，存放已经创建完成，但没有注入好的对象!
 // singletonFactories --> 提前暴露的对象，存放已经完成，但是还没有注入好的工厂对象！通过这个工厂可以返回这个对象！
````
- spring三级缓存的大致流程
> A在创建过程中需要B，于是A先将自己放到三级缓存里面，去实例化B

> B实例化的时候发现需要A，于是B先查一级缓存，没有再查二级缓存，还是没有，再查三级缓存，找到了A；然后把三级缓存里面的这个A放到二级缓存里面，并删除三级缓存里面的A

>   B顺利初始化完毕，将自己放到一级缓存里面（此时B里面的A依然是创建中状态）；然后回来接着创建A，此时B已经创建结束，直接从一级缓存里面拿到B，然后完成创建，并将A放入到一级缓存中
- 5.spring中循环依赖是怎么解决的?


- spring-jdbc模块是为了契合DataSource多数据源的切换
  - Spring中提供的基础类
    - 继承AbstractRoutingDataSource
    - 实现DataSource