package com.ecology.utils.proxy;

/**
 * @author: Mr.Gao
 * @date: 2022年05月25日 11:03
 * @description:
 */
public class ServiceAImpl implements IService {
    @Override
    public void m1() {
        System.out.println("ServiceAImpl.m1()方法已被执行!");
    }

    @Override
    public void m2() {
        System.out.println("ServiceAImpl.m2()方法已被执行!");
    }

    @Override
    public void m3() {
        System.out.println("ServiceAImpl.m3()方法已被执行!");
    }
}
