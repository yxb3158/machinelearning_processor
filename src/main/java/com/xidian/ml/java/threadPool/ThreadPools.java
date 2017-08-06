package com.xidian.ml.java.threadPool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by yxb on 16/12/29.
 */

public abstract class ThreadPools {
    public static final Logger logger = LoggerFactory.getLogger(ThreadPools.class);
    private Integer currentThreadCount = 1;
    private Integer currentQueueSize = 10;

    private ThreadPoolExecutor baseThreadPool;
    private AtomicLong runningPageCount = new AtomicLong();

    protected void initThreadPool() {
        Integer mccThreadCount = getMccThreadCount();
        Integer mccQueueSize = getMccQueueSize();
        if (null == mccThreadCount || null == mccQueueSize) {
            logger.warn("BaseThreadPool. mcc configuration is invalid mccThreadCount:{},mccQueueSize:{}", mccThreadCount, mccQueueSize);
            return;
        }
        if (baseThreadPool == null || baseThreadPool.isShutdown() || !currentThreadCount.equals(mccThreadCount) || !currentQueueSize.equals(mccQueueSize)) {
            currentThreadCount = mccThreadCount;
            currentQueueSize = mccQueueSize;
            releaseThreadPool();
            ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue(currentQueueSize);
            logger.warn("BaseThreadPool.initThreadPool() currentThreadCount:{} currentQueueSize:{}", currentThreadCount, currentQueueSize);
            baseThreadPool = new ThreadPoolExecutor(currentThreadCount, currentThreadCount, 0L, TimeUnit.MILLISECONDS, workQueue, new RejectedExecutionHandler() {
                @Override
                public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                    logger.warn("baseThreadPool Thread Pool Queue FULL!");
                    try {
                        Thread.sleep(100);
                        while (baseThreadPool.getQueue().remainingCapacity() == 0) {
                            Thread.sleep(100);
                        }
                        executor.submit(r);
                    } catch (Exception e) {
                        logger.error("queue full sleep & submit error. ", e);
                    }
                }
            });

        }
    }

    private void releaseThreadPool() {
        if (baseThreadPool != null) {
            int waitTimes = 0;
            int eachTimes = 50;
            while (runningPageCount.get() > 0) {
                threadSleep(eachTimes);
                waitTimes += eachTimes;
            }
            logger.warn("BaseThreadPool.releaseThreadPool() waitTimes:{} ms", waitTimes);
            baseThreadPool.shutdown();
        }
    }

    private void threadSleep(int sleepTime) {
        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            logger.error("BaseThreadPool.sleep:{} ms error. and return", sleepTime, e);
        }
    }

    /**
     * DOCUMENT ME!
     * 有返回值
     *
     * @param work DOCUMENT ME!
     */
    public void submit(Callable<Boolean> work) {
        try {
            initThreadPool();
            Runnable task = new CommonWorkThread(work);
            baseThreadPool.execute(task);
        } catch (Exception e) {
            logger.error("BaseThreadPool dispatch task error", e);
        }
    }

    class CommonWorkThread implements Runnable {
        Callable<Boolean> work = null;

        public CommonWorkThread(Callable<Boolean> work) {
            this.work = work;
        }

        public void setWork(Callable<Boolean> work) {
            this.work = work;
        }

        public Callable<Boolean> getWork() {
            return this.work;
        }

        public void run() {
            runningPageCount.addAndGet(1);
            try {
                if (work != null) {
                    work.call();
                }
            } catch (Exception e) {
                // 不再处理了
                logger.error("BaseThreadPool error.", e);
            } finally {
                runningPageCount.addAndGet(-1);
            }
        }


    }



    /**
     * DOCUMENT ME!
     * 无返回值
     *
     * @param work DOCUMENT ME!
     */
    public void submit(IThreadWork work) {
        try {
            initThreadPool();
            Runnable task = new CommonWorkThread1(work);
            baseThreadPool.execute(task);
        } catch (Exception e) {
            logger.error("BaseThreadPool dispatch task error", e);
        }
    }

    class CommonWorkThread1 implements Runnable {
        IThreadWork work = null;

        public CommonWorkThread1(IThreadWork work) {
            this.work = work;
        }

        public void setWork(IThreadWork work) {
            this.work = work;
        }

        public IThreadWork getWork() {
            return this.work;
        }

        public void run() {
            runningPageCount.addAndGet(1);
            try {
                if (work != null) {
                    work.doWork();
                }
            } catch (Exception e) {
                // 不再处理了
                logger.error("BaseThreadPool error.", e);
            } finally {
                runningPageCount.addAndGet(-1);
            }
        }
    }


    protected abstract Integer getMccThreadCount();

    protected abstract Integer getMccQueueSize();
}

