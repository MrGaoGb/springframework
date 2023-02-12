package com.series.demo.pooltest;


import java.lang.ref.WeakReference;

/**
 * @author: Mr.Gao
 * @date: 2022年11月21日 11:45
 * @description: ThreadLocal解析
 * <p>
 * // -- 设置值
 * threadLocal.set("AAAA");
 * // -- 获取值
 * threadLocal.get();
 * // -- 删除值
 * threadLocal.remove();
 * </p>
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        // 线程A和线程B存储在ThreadLocal中的变量互不干扰，线程A存储的变量只能由线程A访问。线程B存储的变量只能由线程B访问。
        //test1();

        //ThreadLocal变量不具有传递性 在主线程设置的值子线程访问不到
        //test2();

        //InheritableThreadLocal使用示例: 在子线程中获取父线程设置的值
        //test3();

        // 获取可用处理器数量
        test4();
    }

    /**
     * 线程A和线程B存储在ThreadLocal中的变量互不干扰，线程A存储的变量只能由线程A访问。线程B存储的变量只能由线程B访问。
     * <p>
     * 1、基于线程本身存储值的
     * 2、同一个线程中上下值会存在覆盖
     * </p>
     */
    public static void test1() {
        // 创建ThreadLocal对象
        ThreadLocal<Object> threadLocal = new ThreadLocal<>();

        threadLocal.set("MAIN");
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());

        Thread threadA = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：" + threadLocal.get());
            // -- 设置值
            threadLocal.set("AAAA");
            // 值会被覆盖
            threadLocal.set("CCCCC");
            // -- 获取值
            threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "：" + threadLocal.get());
            // -- 删除值
            threadLocal.remove();
            System.out.println(Thread.currentThread().getName() + "：" + threadLocal.get());
        }, "T-A");

        Thread threadB = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "：" + threadLocal.get());
            // -- 设置值
            threadLocal.set("BBBB");
            // -- 获取值
            threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "：" + threadLocal.get());
        }, "T-B");

        // 启动线程
        threadA.start();
        threadB.start();
    }

    /**
     * ThreadLocal变量不具有传递性: 在主线程设置的值子线程访问不到
     */
    public static void test2() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        // Main线程设置值
        threadLocal.set("ThreadLocalTest2");
        Thread a = new Thread(() -> {
            //子线程a 获取值 为null
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        });

        a.start();
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
    }

    /**
     * InheritableThreadLocal使用示例: 在子线程中获取父线程设置的值
     */
    public static void test3() {
        ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();
        // Main线程设置值
        threadLocal.set("ThreadLocalTest3");
        Thread a = new Thread(() -> {
            //子线程a 获取值 为null
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
            threadLocal.set("test3");
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        });
        Thread b = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
        });
        a.start();
        b.start();
        System.out.println(Thread.currentThread().getName() + ":" + threadLocal.get());
    }

    /**
     * 获取核心数
     */
    public static void test4() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
