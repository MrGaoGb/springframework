package com.series.demo.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author: Mr.Gao
 * @date: 2022年05月24日 0:09
 * @description:
 */
public class SpringIocUtil {

    /**
     * 获取Spring容器
     *
     * @param xmlPath
     * @return
     */
    public static ApplicationContext getContext(String xmlPath) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
        return applicationContext;
    }
}
