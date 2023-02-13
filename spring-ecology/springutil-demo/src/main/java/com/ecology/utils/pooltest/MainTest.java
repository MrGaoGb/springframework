package com.ecology.utils.pooltest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author: Mr.Gao
 * @date: 2022年07月19日 17:54
 * @description:
 */
public class MainTest {
    public static void main(String[] args) throws InterruptedException {

        List<Callable<Void>> tasks = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            tasks.add(() -> {
                System.out.println("callable " + finalI);
                Thread.sleep(500);
                return null;
            });
        }

        //ExecutorService executor = Executors.newFixedThreadPool(2);

        // 采用自定义线程池 DiscardPolicy 采用静默处理方式
        ExecutorService executor = new ThreadPoolExecutor(1,
                1,
                2,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(1),
                new ThreadPoolExecutor.DiscardPolicy());

        Thread executorInvokerThread = new Thread(() -> {
            try {
                executor.invokeAll(tasks);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("invokeAll returned");
        });
        executorInvokerThread.start();

        // 线程资源关闭
        TimeUnit.SECONDS.sleep(2);
        System.out.println("shutdown");
        //executor.shutdown();
        // BUG 变形
        List<Runnable> runnableList = executor.shutdownNow();
        for (Runnable r : runnableList) {
            if (r instanceof FutureTask) ((FutureTask<?>) r).cancel(false);
        }
        System.out.println("shutdown complete!");
    }
}
