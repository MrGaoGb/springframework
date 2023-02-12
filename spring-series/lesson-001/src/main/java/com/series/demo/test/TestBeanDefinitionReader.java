package com.series.demo.test;

import com.series.demo.service.AccountService;
import com.series.demo.service.UserService;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.AnnotatedBeanDefinitionReader;

/**
 * @author: Mr.Gao
 * @date: 2022年06月21日 10:19
 * @description:
 */
public class TestBeanDefinitionReader {

    public static void main(String[] args) {
        //testXmlToBeanDefinitionReader();
        annotationToBeanDefinitionReader();
    }

    /**
     * Xml解析为BeanDefinition
     */
    public static void testXmlToBeanDefinitionReader() {
        // 创建Spring容器
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //定义一个XML的BeanDefinition读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int beanDefinitionCount = reader.loadBeanDefinitions("classpath:reader-beans.xml");
        System.out.println("找到:" + beanDefinitionCount + " 个Bean对象!");
        final String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(String.format("beanName:%s --> bdf:%s --> %s", beanName, beanFactory.getBeanDefinition(beanName), beanFactory.getBean(beanName)));
        }
    }
    /**
     * property解析为BeanDefinition
     */

    /**
     * 注解定义解析为BeanDefinition
     */
    public static void annotationToBeanDefinitionReader() {

        //定义Spring容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        //注解解析Bean
        AnnotatedBeanDefinitionReader reader = new AnnotatedBeanDefinitionReader(beanFactory);

        //注解注册Bean
        reader.register(UserService.class, AccountService.class);

        //TODO 会将被Autowired注释标识的AccountService注入到UserService，否则为NULL
        beanFactory.getBeansOfType(BeanPostProcessor.class)
                .values()
                .forEach(beanFactory::addBeanPostProcessor);

        // 从容器中获取所有beanName
        String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            System.out.println(String.format("beanName:%s --> bdf:%s --> %s", beanName, beanFactory.getBeanDefinition(beanName), beanFactory.getBean(beanName)));
        }
    }

}
