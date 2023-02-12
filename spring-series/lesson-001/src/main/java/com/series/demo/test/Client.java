package com.series.demo.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @author: Mr.Gao
 * @date: 2022年05月17日 23:05
 * @description:
 */
public class Client {
    public static void main(String[] args) {
        //-- 获取上下文context
        // -- classpath:beans.xml 和 beans.xml都是可以的
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        // --从容器中获取指定bean
        //HelloWorld helloWorld = applicationContext.getBean(HelloWorld.class);
        // --引用bean的方法
        //helloWorld.say();

        // -- 从容器中获取所有的Bean对象
        final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            // -- 根据beanName获取对应该Bean的所有别名
//            final String[] aliases = applicationContext.getAliases(beanName);
//            System.out.println(String.format("beanName:%s, 别名:[%s]", beanName, String.join(",", aliases)));
            System.out.println(String.format("beanName:%s ---> Bean对象:%s", beanName, applicationContext.getBean(beanName)));
        }

        System.out.println("---------GET FactoryBean Create---------");
        // -- 查看多次获取userFactoryBean是否为同一个对象
        System.out.println("userFactoryBean:" + applicationContext.getBean("userFactoryBean"));
        System.out.println("userFactoryBean:" + applicationContext.getBean("userFactoryBean"));


        // page:43


        System.out.println("----------------------Valid Bean Scope-----------------");

    }
}
