package com.series.demo.test.event;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author: Mr.Gao
 * @date: 2022年06月30日 15:13
 * @description:
 */
public class TestEvent {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext();
        applicationContext.register(EventConfig.class);

        applicationContext.refresh();

        UserRegisterService userRegisterService = applicationContext.getBean(UserRegisterService.class);
        userRegisterService.userRegister("Mr.Gao");
    }
}
