package com.series.demo.test;

import com.series.demo.proxy.*;

/**
 * @author: Mr.Gao
 * @date: 2022年05月25日 11:05
 * @description:
 */
public class ProxyClientTest {
    /**
     * Cglib和Jdk动态代理的区别?
     * 1、Java的JDK代理仅能够对接口进行代理，不能对普通的类进行代理(因为所有生成代理类的父类是java.lang.reflect.Proxy，Java类继承机制不允许多继承)，而Cglib能够代理普通类。
     * 2、Java动态代理使用Java原生的反射API进行操作，在生成类上比较高效；Cglib使用ASM框架直接对字节码进行操作，在类的执行过程比较高效。
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * Jdk代理
         */
        System.out.println("=============Jdk代理=================");
        IService serviceA = JdkProxyInvocationHandler.createProxy(new ServiceAImpl(), IService.class);
        IService serviceB = JdkProxyInvocationHandler.createProxy(new ServiceBImpl(), IService.class);
        System.out.println("serviceA====================");
        serviceA.m1();
        serviceA.m2();
        serviceA.m3();
        System.out.println("serviceB====================");
        serviceB.m1();
        serviceB.m2();
        serviceB.m3();
        /**
         * Cglib代理
         */
        System.out.println("=============Cglib代理=================");
        ConService proxy = CglibProxyMethodInterceptor.createProxy(new ConService());
        proxy.m1();
        proxy.m2();
        proxy.m3();
    }
}
