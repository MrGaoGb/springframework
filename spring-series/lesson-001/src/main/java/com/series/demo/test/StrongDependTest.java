package com.series.demo.test;

import com.series.demo.utils.SpringIocUtil;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Mr.Gao
 * @date: 2022年05月24日 17:18
 * @description:
 */
public class StrongDependTest {
    public static void main(String[] args) {
        System.out.println("Spring 容器启动中!");
        ClassPathXmlApplicationContext context = (ClassPathXmlApplicationContext) SpringIocUtil.getContext("normal-beans.xml");
        System.out.println("Spring 容器启动完毕，准备关闭Spring容器!");
        context.close();//模拟关闭容器
        System.out.println("Spring 容器已关闭!");
    }
}
