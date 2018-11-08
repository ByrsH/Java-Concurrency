package org.yrs.concurrency.javaConcurrencyInPractice.chapter7;

import net.jcip.annotations.GuardedBy;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yangrusheng
 * @Description: 使用volatile类型的域来保存取消状态
 * @Date: Created in 9:13 2018/11/8
 * @Modified By:
 */
public class PrimeGenerator implements Runnable{
    @GuardedBy("this")
    private final List<BigInteger> primes = new ArrayList<BigInteger>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        this.cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }
}
