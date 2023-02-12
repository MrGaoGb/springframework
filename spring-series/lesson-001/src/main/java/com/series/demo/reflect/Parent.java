package com.series.demo.reflect;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: Mr.Gao
 * @date: 2022年06月15日 20:42
 * @description:
 */
public class Parent<T> {

    AtomicInteger updateCount = new AtomicInteger();

    private T value;

    @Override
    public String toString() {
        return String.format("value: %s updateCount:%d", value, updateCount.get());
    }

    public void setValue(T value) {
        this.value = value;
        System.out.println("Parent.setValue called");
        updateCount.getAndIncrement();
    }
}
