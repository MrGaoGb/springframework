package com.ecology.springboot.selector;

import com.ecology.springboot.service.impl.AccountService;
import com.ecology.springboot.service.impl.UserServiceImpl;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author Mr.Gao
 * @date 2023/2/27 10:24
 * @apiNote:
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        importingClassMetadata.getAnnotationTypes().forEach(System.out::println);

        // 此处表示仅注入指定类型的bean
        return new String[]{AccountService.class.getName(), UserServiceImpl.class.getName(), MyImportBeanDefinitionRegistrar.class.getName()};
    }
}
