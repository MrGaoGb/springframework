package com.series.demo.test;

import com.series.demo.createbean.InitBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author: Mr.Gao
 * @date: 2022年06月28日 10:58
 * @description:
 */
public class TestInitBean {
    public static void main(String[] args) {
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //指定init方法
        //TODO afterPropertiesSet() > initMethod()
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(InitBean.class)
                .setInitMethodName("init").getBeanDefinition();
        beanFactory.registerBeanDefinition("initBean", beanDefinition);
        System.out.println("------------------------");
        System.out.println(beanFactory.getBean(InitBean.class));
    }
}
