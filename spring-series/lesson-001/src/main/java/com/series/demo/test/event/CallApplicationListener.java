package com.series.demo.test.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

/**
 * @author: Mr.Gao
 * @date: 2022年07月01日 10:11
 * @description:
 */
@Component
public class CallApplicationListener implements ApplicationListener<UserRegisterEvent> {
    @Override
    public void onApplicationEvent(UserRegisterEvent event) {
        System.out.println("_____________Call服务模块_____________________");
        System.out.println(String.format("[%s]-接收到(%s)注册成功的讯息!", Thread.currentThread(), event.getUserName()));
        //进行打电话通知
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Call通知完成" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));

    }
}
