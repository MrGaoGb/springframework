package com.series.demo.juc.pool;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Mr.Gao
 * @date 2022/12/15 9:34
 * @apiNote:
 */
public class TaskProcessUtil {

    // 每个任务，都有自己单独的线程池
    private static Map<String, ExecutorService> executors = new ConcurrentHashMap<>();

    // 初始化一个线程池
    private static ExecutorService init(String poolName, int poolSize) {
        return new ThreadPoolExecutor(poolSize, poolSize, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(), new ThreadFactoryBuilder().setNameFormat("Pool-" + poolName).setDaemon(false).build(), new ThreadPoolExecutor.CallerRunsPolicy());
    }

    /**
     * 获取线程池
     * 获取线程池可能会存在并发情况，所以需要加一个 synchronized 锁，然后锁住后，需要对 executorService 进行二次判空校验，即引用设计模式之单例模式(双重检查锁(Double-Checked Locking)
     * 简称：DCL)。
     *
     *
     * @param poolName
     * @param poolSize
     * @return
     */
    public static ExecutorService getOrInitExecutors(String poolName, int poolSize) {
        ExecutorService executorService = executors.get(poolName);
        if (null == executorService) {
            synchronized (TaskProcessUtil.class) {
                executorService = executors.get(poolName);
                if (null == executorService) {
                    executorService = init(poolName, poolSize);
                    executors.put(poolName, executorService);
                }
            }
        }
        return executorService;
    }

    // 回收线程资源
    public static void releaseExecutors(String poolName) {
        ExecutorService executorService = executors.remove(poolName);
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
