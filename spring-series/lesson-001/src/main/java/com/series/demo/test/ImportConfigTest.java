package com.series.demo.test;

import com.series.demo.config.ConfigurationBean2;
import com.series.demo.service.*;
import com.series.demo.service.autowired.IService;
import com.series.demo.service.autowired.MainAutowiredConfig;
import com.series.demo.service.autowired.Service0;
import com.series.demo.service.autowired.Service1;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:58
 * @description:
 */
public class ImportConfigTest {
    public static void main(String[] args) {
        /**
         * MainConfig: @Import导入两个普通的类
         * MainConfig2：ImportBeanDefinitionRegistrar接口方式通过@Import导入
         * MainConfig5：ImportSelector接口通过@Import导入
         * MainConfig9: 测试DeferredImportSelector和ImportSelector执行顺序
         * MainAutowiredConfig: @Autowired
         * MainConfig10: 构造方法注入
         */
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(MainConfig13.class);
        // -- 从容器中获取所有的Bean对象
        final String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            // -- 根据beanName获取对应该Bean的所有别名
            final String[] aliases = applicationContext.getAliases(beanName);
            System.out.println(String.format("beanName:%s  ---别名:[%s]---> Bean对象:%s", beanName, String.join(",", aliases), applicationContext.getBean(beanName)));
        }
        // 257
//        System.out.println(applicationContext.getBean(Service1.class));
//        System.out.println(applicationContext.getBean(Service1.class));
//        System.out.println(applicationContext.getBean(Service1.class));
//        System.out.println(applicationContext.getBean(Service0.class));
//        System.out.println(applicationContext.getBean(Service0.class));
//        System.out.println(applicationContext.getBean(Service0.class));
    }
}
