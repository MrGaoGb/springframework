package com.series.demo.test.cycledependency;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Mr.Gao
 * @date: 2022年07月04日 11:33
 * @description:
 */
public class TestCycleDependency {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.register(CycleConfig.class);
        // 开始启动容器
        System.out.println("开始启动容器!");
        applicationContext.refresh();
        System.out.println("容器启动完毕!");
    }
}
