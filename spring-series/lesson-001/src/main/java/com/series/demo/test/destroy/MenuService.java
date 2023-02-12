package com.series.demo.test.destroy;

import javax.annotation.PreDestroy;

/**
 * @author: Mr.Gao
 * @date: 2022年06月28日 15:48
 * @description:
 */
public class MenuService {

    public MenuService(String name) {
        System.out.println("MenuService created " + name);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("PreDestroy()");
    }
}
