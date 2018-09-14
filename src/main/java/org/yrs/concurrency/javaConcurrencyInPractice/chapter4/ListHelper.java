package org.yrs.concurrency.javaConcurrencyInPractice.chapter4;

import net.jcip.annotations.ThreadSafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: yangrusheng
 * @Description: 通过客户端加锁来实现“若没有则添加”方法
 * @Date: Created in 18:16 2018/9/14
 * @Modified By:
 */
@ThreadSafe
public class ListHelper<E> {

    public List<E> list = Collections.synchronizedList(new ArrayList<E>());

    public boolean putIfAbsent(E x) {
        synchronized (list) {
            boolean absent = !list.contains(x);
            if (absent) {
                list.add(x);
            }
            return absent;
        }
    }

}
