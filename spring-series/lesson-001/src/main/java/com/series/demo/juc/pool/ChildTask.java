package com.series.demo.juc.pool;

import com.google.common.collect.Lists;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Mr.Gao
 * @date 2022/12/15 11:47
 * @apiNote:
 */
public class ChildTask {
    private final int POOL_SIZE = 3; // 线程池大小
    private final int SPLIT_SIZE = 4; // 数据拆分大小
    private String taskName;

    // 接收jvm关闭信号，实现优雅停机

    protected volatile AtomicInteger count = new AtomicInteger(0);
    protected volatile boolean terminal = false;

    public ChildTask(String taskName) {
        this.taskName = taskName;
    }

    /**
     * 程序执行入口，封装了每个任务执行的流程，当 terminal=true 时，先执行完任务数据，然后回收线程池，最后退出。
     */
    public void doExecute() {
        int i = 0;
        while (true) {
            System.out.println(taskName + ":Cycle-" + i + "-Begin");
            // 获取数据
            List<Cat> datas = queryData();
            // 处理数据
            taskExecute(datas);
            System.out.println(taskName + ":Cycle-" + i + "-End");
            if (terminal) {
                // 只有应用关闭，才会走到这里，用于实现优雅的下线
                break;
            }
            i++;
        }
        // 回收线程池资源
        TaskProcessUtil.releaseExecutors(taskName);
    }

    /**
     * 优雅停机 ：仅用于接受停机命令，这里该变量定义为 volatile，所以多线程内存可见；
     */
    public void terminal() {
        // 关机
        terminal = true;
        System.out.println(taskName + " shut down");
    }

    /**
     * 数据处理逻辑，实际应用中其实是需要把 doProcessData 定为抽象方法，然后由各个任务实现自己的方法。
     *
     * @param datas
     * @param latch
     */
    private void doProcessData(List<Cat> datas, CountDownLatch latch) {
        try {
            for (Cat cat : datas) {
                System.out.println(taskName + ":" + cat.toString() + ",ThreadName:" + Thread.currentThread().getName());
                Thread.sleep(1000L);
            }
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        } finally {
            if (latch != null) {
                latch.countDown();
            }
        }
    }

    /**
     * 需要把数据拆分成 4 份，然后分别由多线程并发执行，这里可以通过线程池支持；
     *
     * @param sourceDatas
     */
    private void taskExecute(List<Cat> sourceDatas) {
        if (CollectionUtils.isEmpty(sourceDatas)) {
            return;
        }
        // 将数据拆成4份
        List<List<Cat>> splitDatas = Lists.partition(sourceDatas, SPLIT_SIZE);
        final CountDownLatch latch = new CountDownLatch(splitDatas.size());

        // 并发处理拆分的数据，共用一个线程池
        for (final List<Cat> datas : splitDatas) {
            ExecutorService executorService = TaskProcessUtil.getOrInitExecutors(taskName, POOL_SIZE);
            executorService.submit(() -> doProcessData(datas, latch));
        }

        try {
            latch.await();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
    }

    /**
     * 获取永动任务数据：这里一般都是扫描 DB，我直接就简单用 queryData() 代替
     *
     * @return
     */
    private List<Cat> queryData() {
        List<Cat> datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            if (count.get() >= 20) {
                datas = new ArrayList<>();
            } else {
                datas.add(new Cat().setCatName("罗小黑" + i));
                count.incrementAndGet();
                System.out.println("==========================="+count.get());
            }
        }
        return datas;
    }
}
