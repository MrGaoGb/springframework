package com.series.demo.test.callback;

import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author: Mr.Gao
 * @date: 2022年06月28日 13:51
 * @description:
 */
@Component
public class CallbackInitBeanService implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("--------------------------");
        System.out.println("所有Bean已初始化完毕!");
    }
}
