package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import net.jcip.annotations.NotThreadSafe;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 20:07 2018/9/13
 * @Modified By:
 */
@NotThreadSafe
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
