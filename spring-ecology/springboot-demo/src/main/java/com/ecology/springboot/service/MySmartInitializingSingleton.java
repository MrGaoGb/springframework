package com.ecology.springboot.service;

import org.springframework.beans.factory.SmartInitializingSingleton;

/**
 * @author Mr.Gao
 * @date 2023/1/11 11:20
 * @apiNote:
 */
public class MySmartInitializingSingleton implements SmartInitializingSingleton {
    @Override
    public void afterSingletonsInstantiated() {
        System.out.println("##########afterSingletonsInstantiated......");
    }
}
