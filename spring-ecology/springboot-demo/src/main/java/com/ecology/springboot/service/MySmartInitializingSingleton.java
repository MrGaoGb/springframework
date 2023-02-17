package com.ecology.springboot.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

/**
 * @author Mr.Gao
 * @date 2023/1/11 11:20
 * @apiNote:
 */
@Slf4j
@Component
public class MySmartInitializingSingleton implements SmartInitializingSingleton {


    @Override
    public void afterSingletonsInstantiated() {
        log.info("##########afterSingletonsInstantiated......");
    }
}
