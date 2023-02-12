package com.series.demo.pooltest;

/**
 * @author: Mr.Gao
 * @date: 2022年11月14日 14:09
 * @description: 对普通方法同步
 */
public class SynchronizeTestDemo2 {

    public synchronized void method1() {
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }


    public synchronized void method2() {
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
        final SynchronizeTestDemo2 synchronizeTestDemo = new SynchronizeTestDemo2();
        new Thread(() -> {
            synchronizeTestDemo.method1();
        }).start();

        new Thread(() -> {
            synchronizeTestDemo.method2();
        }).start();

    }


}
