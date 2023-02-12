package com.series.demo.test.event;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author: Mr.Gao
 * @date: 2022年06月30日 15:06
 * @description:
 */
@Service
public class ListenerProcess {


//    @EventListener(classes = UserRegisterEvent.class)
//    public void resisterSucc(UserRegisterEvent event) {
//        System.out.println("接收广播事件时间:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
//        System.out.println("接收到" + event.getUserName() + "注册成功的讯息");
//        // 开始发送短信通知
//        System.out.println("开始发送短信通知!");
//    }
}
