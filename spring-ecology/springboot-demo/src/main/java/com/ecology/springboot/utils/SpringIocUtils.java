package com.ecology.springboot.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Mr.Gao
 * @date 2023/2/13 9:48
 * @apiNote:
 */
public class SpringIocUtils {

    /**
     * 获取上下文容器
     *
     * @return
     */
    public static ApplicationContext getApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        return context;
    }

}
