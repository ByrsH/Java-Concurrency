package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import net.jcip.annotations.ThreadSafe;

import java.util.List;

/**
 * @Author: yangrusheng
 * @Description: 通过组合实现“若没有则添加”方法
 * @Date: Created in 18:20 2018/9/14
 * @Modified By:
 */
@ThreadSafe
public class ImproveList<T> implements List<T> {

    private final List<T> list;

    public ImproveList(List<T> list) {
        this.list = list;
    }

    public synchronized boolean putIfAbsent(T x) {
        boolean absent = !list.contains(x);
        if (absent) {
            list.add(x);
        }
        return absent;
    }

    public synchronized void clear() {
        this.list.clear();
    }

}
