package com.series.demo.test.event;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Gao
 * @date: 2022年06月30日 15:32
 * @description:
 */
@Component
@Order(1)
public class SmsApplicationListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("_____________SMS短信服务模块_____________________");
        System.out.println(String.format("[%s]-接收到(%s)注册成功的讯息!", Thread.currentThread(), event.getUserName()));
        // 开始发送短信通知
        System.out.println("开始发送短信Sms通知!");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Sms通知完成" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
    }
}
