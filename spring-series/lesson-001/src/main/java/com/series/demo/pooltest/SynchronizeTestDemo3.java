package com.series.demo.pooltest;

/**
 * @author: Mr.Gao
 * @date: 2022年11月14日 14:09
 * @description: 静态方法(类)同步
 */
public class SynchronizeTestDemo3 {

    public synchronized static void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }


    public synchronized static void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }


    public static void main(String[] args) throws InterruptedException {
        SynchronizeTestDemo3 synchronizeTestDemo1 = new SynchronizeTestDemo3();
        SynchronizeTestDemo3 synchronizeTestDemo2 = new SynchronizeTestDemo3();

        synchronizeTestDemo2.wait();
        new Thread(() -> {
            synchronizeTestDemo1.method1();
        }).start();

        new Thread(() -> {
            synchronizeTestDemo2.method2();
        }).start();

    }


}
