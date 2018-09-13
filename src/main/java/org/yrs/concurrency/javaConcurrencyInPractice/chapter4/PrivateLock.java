package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import net.jcip.annotations.GuardedBy;

/**
 * @Author: yangrusheng
 * @Description: 通过一个私有锁来保护状态
 * @Date: Created in 19:46 2018/9/13
 * @Modified By:
 */
public class PrivateLock {
    private final Object myLock = new Object();
    @GuardedBy("myLock") Widget widget;

    void someMethod() {
        synchronized (myLock) {
            //访问或修改widget的状态
        }
    }
}
