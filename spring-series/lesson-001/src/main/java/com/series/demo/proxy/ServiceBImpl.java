package com.series.demo.proxy;

/**
 * @author: Mr.Gao
 * @date: 2022年05月25日 11:03
 * @description:
 */
public class ServiceBImpl implements IService {
    @Override
    public void m1() {
        System.out.println("ServiceBImpl.m1()方法已被执行!");
    }

    @Override
    public void m2() {
        System.out.println("ServiceBImpl.m2()方法已被执行!");
    }

    @Override
    public void m3() {
        System.out.println("ServiceBImpl.m3()方法已被执行!");
    }
}
