package org.yrs.concurrency.javaConcurrencyInPractice.chapter5;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: yangrusheng
 * @Description: 在计时测试中使用CountDownLatch来启动和停止线程
 * @Date: Created in 9:22 2018/10/16
 * @Modified By:
 */
public class TestHarness {
    public long timeTasks(int nThreads, final Runnable task) throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i = 0; i < nThreads; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {}
                }
            };
            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }
}
