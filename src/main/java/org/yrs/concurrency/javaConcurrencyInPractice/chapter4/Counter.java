package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @Author: yangrusheng
 * @Description: 使用Java监视器模式的线程安全计数
 * @Date: Created in 8:38 2018/9/13
 * @Modified By:
 */
@ThreadSafe
public final class Counter {
    @GuardedBy("this") private long value = 0;

    public synchronized long getValue() {
        return value;
    }

    public synchronized long increment() {
        if (value == Long.MAX_VALUE) {
            throw new IllegalStateException("counter overflow");
        }
        return ++value;
    }
}
