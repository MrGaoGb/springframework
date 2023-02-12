package com.series.demo.test.destroy;

import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.CommonAnnotationBeanPostProcessor;

/**
 * @author: Mr.Gao
 * @date: 2022年06月28日 15:49
 * @description:
 */
public class TestDestroy {
    public static void main(String[] args) {

        // 创建Spring容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerBeanDefinition("menuService1", BeanDefinitionBuilder.genericBeanDefinition(MenuService.class.getName()).addConstructorArgValue("menuService1").getBeanDefinition());
        beanFactory.registerBeanDefinition("menuService2", BeanDefinitionBuilder.genericBeanDefinition(MenuService.class.getName()).addConstructorArgValue("menuService2").getBeanDefinition());
        beanFactory.registerBeanDefinition("menuService3", BeanDefinitionBuilder.genericBeanDefinition(MenuService.class.getName()).addConstructorArgValue("menuService3").getBeanDefinition());

        //TODO 重写DestructionAwareBeanPostProcessor 打印日志 输出被销毁的Bean名称
        beanFactory.addBeanPostProcessor((DestructionAwareBeanPostProcessor) (bean, beanName) -> System.out.println("被销毁的Bean:" + beanName));

        //TODO 添加识别@PreDestroy注释的BeanPostProcessor --> CommonAnnotationBeanPostProcessor
        beanFactory.addBeanPostProcessor(new CommonAnnotationBeanPostProcessor());

        // 触发所有bean初始化
        beanFactory.preInstantiateSingletons();

        // 销毁指定的BeanName
        System.out.println("销毁menuService1");
        beanFactory.destroySingleton("menuService1");
        System.out.println("------------------");
        // 销毁所有的bean
        beanFactory.destroySingletons();
    }
}
