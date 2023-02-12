package com.series.demo.service;

import com.series.demo.service.autowired.Service0;
import com.series.demo.service.autowired.Service1;
import com.series.demo.service.autowired.Service2;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Scope;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description: @DependsOn 指定当前Bean所依赖的Bean
 */
@Configuration
public class MainConfig13 {

    /**
     * 实现IService接口
     *
     * @return
     */
    @Bean
    @DependsOn({"service0", "service2"})
    public Service1 service1() {
        return new Service1();
    }

    /**
     * 实现IService接口
     *
     * @return
     */
    @Bean
    public Service0 service0() {
        return new Service0();
    }

    /**
     * Service2没有实现IService接口
     *
     * @return
     */
    @Bean
    public Service2 service2() {
        return new Service2();
    }

}
