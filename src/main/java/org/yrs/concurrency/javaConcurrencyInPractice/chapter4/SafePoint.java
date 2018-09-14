package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

/**
 * @Author: yangrusheng
 * @Description: 线程安全且可变的Point类
 * @Date: Created in 10:16 2018/9/14
 * @Modified By:
 */
@ThreadSafe
public class SafePoint {
    @GuardedBy("this") private int x, y;

    private SafePoint(int[] a) {
        this.x = a[0];
        this.y = a[1];
    }

    public SafePoint(SafePoint p) {
        this(p.get());
    }

    public SafePoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public synchronized int[] get() {
        return new int[] {x, y};
    }

    public synchronized void set(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
