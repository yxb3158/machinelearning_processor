package com.xidian.ml.java.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ThreadPoolUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolUtil.class);

    private static ThreadPoolExecutor taskSegThreadPool = null;
    private static ThreadPoolExecutor custSegThreadPool = null;
    private static ThreadPoolExecutor taskSegChannelThreadPool = null;

    private static int taskSegThreadCount = 0;
    private static int taskSegQueueSize = 0;
    private static int custSegThreadCount = 0;
    private static int custSegQueueSize = 0;
    private static int taskSegChannelThreadCount = 0;
    private static int taskSegChannelQueueSize = 0;

    public static ThreadPoolExecutor getTaskSegChannelThreadPool() {
        Integer tCount = 3;
        Integer qSize = 10;
        if (taskSegChannelThreadPool != null) {
            if (tCount == taskSegChannelThreadCount && qSize == taskSegChannelQueueSize) {
                if (!taskSegChannelThreadPool.isShutdown()) {
                    return taskSegChannelThreadPool;
                } else {
                    LOGGER.warn("taskSegChannelThreadPool isShutdown");
                }
            } else {
                LOGGER.warn("taskSegChannelThreadPool mcc changed");
            }
        }
        while (taskSegChannelThreadPool != null && taskSegChannelThreadPool.isShutdown() && !taskSegChannelThreadPool.isTerminated()) {
            LOGGER.warn("taskSegChannelThreadPool isShutdown not terminated");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        taskSegChannelThreadCount = tCount;
        taskSegChannelQueueSize = qSize;
        LOGGER.warn("taskSegChannelThreadPool threadCount:{} queueSize:{}", tCount, qSize);
        ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(qSize);

        taskSegChannelThreadPool = new ThreadPoolExecutor(tCount, tCount, 0L, TimeUnit.MILLISECONDS, workQueue, new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                try {
                    LOGGER.warn("taskSegChannelThreadPool queue full skip, size:{}", taskSegChannelThreadPool.getQueue().size());
                    int retryTimes = 1000;
                    int n = 0;
                    while ((n < retryTimes) && taskSegChannelThreadPool.getQueue().remainingCapacity() == 0) {
                        Thread.sleep(2000);
                        n++;
                    }
                    LOGGER.warn("taskSegChannelThreadPool queue full skip redo, size:{}, n:{}", taskSegChannelThreadPool.getQueue().size(), n);
                    if (n < retryTimes) {
                        taskSegChannelThreadPool.submit(r);
                    } else {
                        r.run();
                    }
                } catch (Exception e) {
                    LOGGER.error("taskSegChannelThreadPool queue full sleep & submit error", e);
                }
            }
        });
        return taskSegChannelThreadPool;
    }
}
