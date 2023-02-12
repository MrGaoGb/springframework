package com.series.demo.service;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 17:53
 * @description:
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinition service1BeanDefinition = BeanDefinitionBuilder.genericBeanDefinition(ImportService1.class)
                .getBeanDefinition();
        registry.registerBeanDefinition("importService1", service1BeanDefinition);
        // --ImportService3 -> 对应的BeanDefinition
        BeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition(ImportService3.class)
                .addPropertyReference("importService1", "importService1")
                .getBeanDefinition();
        registry.registerBeanDefinition("importService3", beanDefinition);

    }
}
