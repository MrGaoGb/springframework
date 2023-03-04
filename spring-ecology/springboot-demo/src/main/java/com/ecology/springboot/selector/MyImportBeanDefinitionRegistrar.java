package com.ecology.springboot.selector;

import com.ecology.springboot.service.impl.AccountService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Mr.Gao
 * @date 2023/2/27 10:26
 * @apiNote:
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(AccountService.class.getName());
        BeanDefinition accountServiceDefinition = BeanDefinitionBuilder.genericBeanDefinition(AccountService.class.getName()).getBeanDefinition();
        registry.registerBeanDefinition("actService", accountServiceDefinition);
    }


}
