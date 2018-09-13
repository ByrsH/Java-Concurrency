package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import jdk.nashorn.internal.ir.annotations.Immutable;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 20:34 2018/9/13
 * @Modified By:
 */
@Immutable
public class Point {
    private final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
