package com.series.demo.test.callback;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: Mr.Gao
 * @date: 2022年06月28日 13:46
 * @description:
 */
@ComponentScan
public class TestSmartInit {
    public static void main(String[] args) {
        /**
         * 会在所有Bean对象初始化完成之后会调用SmartInitializingSingleton.afterSingletonsInstantiated()
         */
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(TestSmartInit.class);
        System.out.println("开始启动容器!");
        System.out.println("--------------------------");
        applicationContext.refresh();
        System.out.println("容器启动完毕!");
    }
}
