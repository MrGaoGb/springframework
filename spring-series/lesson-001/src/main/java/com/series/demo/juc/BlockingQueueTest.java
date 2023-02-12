package com.series.demo.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author: Mr.Gao
 * @date: 2022年12月06日 10:01
 * @description:
 */
public class BlockingQueueTest {
    public static void main(String[] args) throws Exception {
        BlockingQueue<String> queue = new ArrayBlockingQueue<>(10);
        queue.add("BBB");
        System.out.println(queue.remainingCapacity());
        queue.put("AAA");
        System.out.println(queue.remainingCapacity());
        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }

}
