package com.series.demo.test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;

import java.util.Arrays;

/**
 * @author: Mr.Gao
 * @date: 2022年06月21日 11:27
 * @description:
 */
public class TestBeanDefinitionRegistry {

    public static void main(String[] args) {
        registryBeanDefinitionByString();
    }

    /**
     * 注册Bean对象之String
     */
    public static void registryBeanDefinitionByString() {
        //创建Spring容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        //创建一个BeanDefinition
        GenericBeanDefinition nameBeanDefinition = new GenericBeanDefinition();
        nameBeanDefinition.setBeanClassName(String.class.getName());
        nameBeanDefinition.getConstructorArgumentValues()
                .addIndexedArgumentValue(0, "Mr.Gao");

        //注册一个BeanDefinition
        beanFactory.registerBeanDefinition("name", nameBeanDefinition);

        //根据名称获取beanDefinition
        System.out.println("根据名称获取beanDefinition:" + beanFactory.getBeanDefinition("name"));
        //判断名称是否在Spring容器中注册过
        System.out.println("判断名称是否在Spring容器中注册过:" + beanFactory.containsBeanDefinition("name"));
        //获取所有注册的名称
        System.out.println("获取所有注册Bean的名称:" + beanFactory.getBeanDefinitionNames());
        // 获取已注册BeanDefinition的数量
        System.out.println("获取已注册BeanDefinition的数量:" + beanFactory.getBeanDefinitionCount());
        //判断指定的beanName是否已被使用过
        System.out.println("判断指定的beanName是否已被使用过:" + beanFactory.isBeanNameInUse("name"));
        //为beanDefinition指定别名
        beanFactory.registerAlias("name", "alias-name-baby-Mr.G");
        beanFactory.registerAlias("name", "alias-name-baby");
        //判断别名是否已经被使用
        System.out.println("判断别名是否已经被使用:" + beanFactory.isAlias("alias-name-baby-1"));
        //获取该名称下所有的别名
        System.out.println("获取该名称下所有的别名:" + Arrays.asList(beanFactory.getAliases("name")));
        //获取这个Bean
        System.out.println("获取bean对象:" + beanFactory.getBean("name"));
    }
}
