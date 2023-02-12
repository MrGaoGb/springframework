package com.series.demo.test;

import com.series.demo.createbean.AwareBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author: Mr.Gao
 * @date: 2022年06月28日 10:05
 * @description:
 */
public class TestAware {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(AwareBean.class.getName())
                .getBeanDefinition();
        beanFactory.registerBeanDefinition("awareBean", beanDefinition);
        System.out.println(beanFactory.getBean(AwareBean.class));
    }
}
