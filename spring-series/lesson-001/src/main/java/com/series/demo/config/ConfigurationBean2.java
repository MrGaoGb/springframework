package com.series.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Mr.Gao
 * @date: 2022年05月25日 16:39
 * @description:
 */
@Configuration
public class ConfigurationBean2 {

    @Bean
    public ServiceA serviceA() {
        //@0
        System.out.println("调用serviceA()方法");
        return new ServiceA();
    }

    @Bean
    ServiceB serviceB1() {
        System.out.println("调用serviceB1()方法");
        //@1
        ServiceA serviceA = this.serviceA();
        return new ServiceB(serviceA);
    }

    @Bean
    ServiceB serviceB2() {
        System.out.println("调用serviceB2()方法");
        //@2
        ServiceA serviceA = this.serviceA();
        return new ServiceB(serviceA);
    }

}
