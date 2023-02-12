package com.series.demo.pooltest;

/**
 * @author: Mr.Gao
 * @date: 2022年11月14日 14:09
 * @description: 没有同步方法
 */
public class SynchronizeTestDemo {

    public void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }


    public void method2() {
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }


    public static void main(String[] args) {
        final SynchronizeTestDemo synchronizeTestDemo = new SynchronizeTestDemo();
        new Thread(() -> {
            synchronizeTestDemo.method1();
        }).start();

        new Thread(() -> {
            synchronizeTestDemo.method2();
        }).start();

    }


}
