package com.series.demo.test.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * @author: Mr.Gao
 * @date: 2022年06月30日 14:52
 * @description:
 */
@Getter
@Setter
public class UserRegisterEvent extends ApplicationEvent {

    private String userName;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public UserRegisterEvent(Object source, String userName) {
        super(source);
        this.userName = userName;
    }


}
