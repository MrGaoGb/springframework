package com.ecology.springboot.annotation;

import com.ecology.springboot.config.SelectorConfig;
import com.ecology.springboot.service.impl.AccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

/**
 * @author Mr.Gao
 * @date 2023/2/27 10:41
 * @apiNote:
 */
public class ImportSelectorTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SelectorConfig.class);

        Arrays.stream(applicationContext.getBeanDefinitionNames()).forEach(beanName -> {
            System.out.println(applicationContext.getBean(beanName));
        });
    }

}
