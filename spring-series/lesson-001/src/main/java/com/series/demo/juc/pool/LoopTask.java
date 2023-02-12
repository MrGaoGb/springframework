package com.series.demo.juc.pool;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Mr.Gao
 * @date 2022/12/15 11:52
 * @apiNote:
 */
public class LoopTask {

    private List<ChildTask> childTasks;

    public void initLoopTask() {
        System.out.printf("#########################################init\n");
        childTasks = new ArrayList();
        childTasks.add(new ChildTask("childTask1"));
        childTasks.add(new ChildTask("childTask2"));
        for (final ChildTask childTask : childTasks) {
            new Thread(() -> childTask.doExecute()).start();
        }
    }

    public void shutdownLoopTask() {
        if (!CollectionUtils.isEmpty(childTasks)) {
            for (ChildTask childTask : childTasks) {
                childTask.terminal();
            }
        }
    }

    public static void main(String args[]) throws Exception {
        LoopTask loopTask = new LoopTask();
        loopTask.initLoopTask();
        TimeUnit.SECONDS.sleep(5 * 60);// 五分钟
        loopTask.shutdownLoopTask();
    }
}
