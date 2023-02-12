package com.series.demo.test.cycledependency;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author: Mr.Gao
 * @date: 2022年07月04日 11:30
 * @description:
 */
@Component
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ServiceB {

    private ServiceA serviceA;

    //通过构造方法构建参数
    public ServiceB(ServiceA serviceA) {
        this.serviceA = serviceA;
    }
}
