package com.series.demo.test;

import com.series.demo.config.ConfigurationBean;
import com.series.demo.config.ConfigurationBean2;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Mr.Gao
 * @date: 2022年05月25日 16:43
 * @description:
 */
public class ConfigurationTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ConfigurationBean2.class);
        // -- 从容器中获取所有的Bean对象
        final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            // -- 根据beanName获取对应该Bean的所有别名
            final String[] aliases = applicationContext.getAliases(beanName);
            System.out.println(String.format("beanName:%s  ---别名:[%s]---> Bean对象:%s", beanName, String.join(",", aliases), applicationContext.getBean(beanName)));
        }


        //page: 174
    }
}
