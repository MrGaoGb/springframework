package com.series.demo.reflect;

/**
 * @author: Mr.Gao
 * @date: 2022年06月15日 20:47
 * @description:
 */
public class Child extends Parent{

    public void setValue(Object value) {
        System.out.println("Child1.setValue called");
        super.setValue(value);
    }
}
