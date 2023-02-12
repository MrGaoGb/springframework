package com.series.demo.pooltest;

/**
 * @author: Mr.Gao
 * @date: 2022年11月10日 9:48
 * @description:测试线程的可见性
 */
public class TestThread {

    /**
     * 定义一个成员变量
     */
    private volatile Long num = 0L;

    /**
     * 对count方法进行累加
     */
    private synchronized void count() {
        for (int i = 0; i < 1000000000; i++) {
            num++;
        }
    }

    /**
     * 创建两个线程 分别调用进行累加求和
     */
    public Long execute() throws InterruptedException {
        Thread threadA = new Thread(() -> count(), "T-A");
        Thread threadB = new Thread(() -> count(), "T-B");
        // 启动线程
        threadA.start();
        threadB.start();

        //等待线程执行结束
        threadA.join();
        threadB.join();

        // 返回总数之和
        return num;
    }

    public static void main(String[] args) throws InterruptedException {
        // 开始执行
        TestThread testThread = new TestThread();
        final Long execute = testThread.execute();
        System.out.println("返回当前总数之和:" + execute);
    }
}
