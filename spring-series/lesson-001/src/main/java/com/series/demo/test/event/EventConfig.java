package com.series.demo.test.event;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author: Mr.Gao
 * @date: 2022年06月30日 15:13
 * @description:
 */
@ComponentScan
public class EventConfig {

    @Bean
    public ApplicationEventMulticaster eventMulticaster(List<ApplicationListener> listeners) {
        SimpleApplicationEventMulticaster eventMulticaster = new SimpleApplicationEventMulticaster();
        // --eventMulticaster.setTaskExecutor();
        if (!CollectionUtils.isEmpty(listeners)) {
            listeners.forEach(listener -> eventMulticaster.addApplicationListener(listener));
        }
        return eventMulticaster;
    }

    @Bean
    public UserRegisterService userRegisterService(ApplicationEventMulticaster eventMulticaster) {
        UserRegisterService userRegisterService = new UserRegisterService();
        userRegisterService.setEventMulticaster(eventMulticaster);
        return userRegisterService;
    }
}
