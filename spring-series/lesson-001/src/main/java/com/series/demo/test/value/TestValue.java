package com.series.demo.test.value;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Mr.Gao
 * @date: 2022年06月29日 16:53
 * @description: @Value属性注入
 */
public class TestValue {

    public static void main(String[] args) {

        //myValue();
        //
        myScopeTest();
    }

    /**
     * 从Properties中获取@Value值
     */
    public static void myValue() {
        final AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(MainConfig.class);
        applicationContext.refresh();
        //获取属性值
        final DbConfig dbConfig = applicationContext.getBean(DbConfig.class);
        System.out.println(dbConfig);
    }


    /**
     * 自定义@Scope测试
     */
    public static void myScopeTest() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 将自定义的作用域 注册到容器中
        applicationContext.getBeanFactory().registerScope(BeanMyScope.MY_SCOPE, new BeanMyScope());
        applicationContext.register(MainConfig.class);

        //刷新容器
        applicationContext.refresh();

        System.out.println("从容器中获取User对象");
        User user = applicationContext.getBean(User.class);
        System.out.println("user对象的class为：" + user.getClass());
        System.out.println("多次调用user的getUsername感受一下效果\n");
        for (int i = 1; i <= 3; i++) {
            System.out.println(String.format("********\n第%d次开始调用getUsername",
                    i));
            System.out.println(user.getUserName());
            System.out.println(String.format("第%d次调用getUsername结束\n********\n",
                    i));
        }

    }
}
