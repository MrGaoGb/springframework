package com.series.demo.service;

import com.series.demo.service.autowired.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author: Mr.Gao
 * @date: 2022年05月26日 16:57
 * @description:总配置执行结果顺序: @Bean结合@Qualifier
 */
@Configuration
public class MainConfig11 {

    /**
     * 实现IService接口
     *
     * @return
     */
    @Bean
    @Qualifier("tag1")
    public Service1 service1() {
        return new Service1();
    }

    /**
     * 实现IService接口
     *
     * @return
     */
    @Bean
    @Qualifier("tag1")
    public Service0 service0() {
        return new Service0();
    }

    /**
     * Service2没有实现IService接口
     *
     * @return
     */
    @Bean
    @Qualifier("tag2")
    public Service2 service2() {
        return new Service2();
    }

    @Bean
    public InjectService injectService(@Qualifier("tag1") Map<String, IService> map) {
        InjectService injectService = new InjectService();
        injectService.setMap(map);
        return injectService;
    }
}
