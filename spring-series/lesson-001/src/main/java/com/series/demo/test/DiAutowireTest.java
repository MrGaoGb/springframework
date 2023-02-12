package com.series.demo.test;

import com.series.demo.utils.SpringIocUtil;
import org.springframework.context.ApplicationContext;

/**
 * @author: Mr.Gao
 * @date: 2022年05月24日 0:17
 * @description:
 */
public class DiAutowireTest {
    public static void main(String[] args) {
        ApplicationContext context = SpringIocUtil.getContext("autowire-beans.xml");
        System.out.println(context.getBean("diAutowireByName1"));
        System.out.println(context.getBean("diAutowireByName2"));
    }
}
