package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import net.jcip.annotations.ThreadSafe;

import java.util.Vector;

/**
 * @Author: yangrusheng
 * @Description: 扩展vector并增加一个“若没有则添加”方法
 * @Date: Created in 18:12 2018/9/14
 * @Modified By:
 */
@ThreadSafe
public class BetterVector<E> extends Vector<E> {

    public synchronized boolean putIfAbsent(E x) {
        boolean absent = !contains(x);
        if (absent) {
            add(x);
        }
        return absent;
    }

}
