package org.yrs.concurrency.javaConcurrencyInPractice.chapter7;

import java.math.BigInteger;
import java.util.concurrent.BlockingDeque;

/**
 * @Author: yangrusheng
 * @Description: 通过中断来取消
 * @Date: Created in 9:14 2018/11/12
 * @Modified By:
 */
public class PrimeProducer extends Thread {
    private final BlockingDeque<BigInteger> queue;

    PrimeProducer(BlockingDeque<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted()) {
                queue.put(p = p.nextProbablePrime());
            }
        } catch (InterruptedException e) {
            /* 允许线程退出 */
        }
    }

    public void cancel() {
        interrupt();
    }
}
