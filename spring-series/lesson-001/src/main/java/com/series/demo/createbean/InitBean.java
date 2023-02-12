package com.series.demo.createbean;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author: Mr.Gao
 * @date: 2022年06月28日 10:57
 * @description:
 */
public class InitBean implements InitializingBean {


    public void init() {
        System.out.println("init()---``--");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet() ------->");
    }
}
