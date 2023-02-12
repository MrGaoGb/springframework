package com.series.demo.test.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.ApplicationEventMulticaster;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Gao
 * @date: 2022年06月30日 14:57
 * @description:
 */
@Service
public class UserRegisterService {

    //    @Autowired
//    private ApplicationEventPublisher publisher;
    private ApplicationEventMulticaster eventMulticaster;

    public void userRegister(String userName) throws Exception {
        //用户注册(将用户信息入库等操作)
        System.out.println(String.format("[%s]-用户【%s】注册成功",Thread.currentThread(), userName));

        //广播事件
        System.out.println("广播事件开始时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        //publisher.publishEvent(new UserRegisterEvent(this, userName));
        eventMulticaster.multicastEvent(new UserRegisterEvent(this, userName));

        //广播事件
        System.out.println("广播事件截止时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }

    public ApplicationEventMulticaster getEventMulticaster() {
        return eventMulticaster;
    }

    public void setEventMulticaster(ApplicationEventMulticaster eventMulticaster) {
        this.eventMulticaster = eventMulticaster;
    }
}
