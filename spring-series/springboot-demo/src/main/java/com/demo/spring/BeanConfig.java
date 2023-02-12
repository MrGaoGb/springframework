package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Gao
 * @date 2023/1/10 16:22
 * @apiNote:
 */
public class BeanConfig {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        System.out.println(context.getBean("person"));
    }


    /**
     * Actor
     * Prometheus:数据采集插件
     * Grafana：监控类工具
     */

}
