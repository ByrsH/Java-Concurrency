package org.yrs.concurrency.javaConcurrencyInPractice.chapter5;

import net.jcip.annotations.NotThreadSafe;

import java.util.Vector;

/**
 * @Author: yangrusheng
 * @Description: 在Vector上执行复合操作可能会抛出异常，可以通过客户端加锁的方式解决。
 * @Date: Created in 8:59 2018/10/11
 * @Modified By:
 */
public class CompositeOperationVector {

    //getLast 执行期间,另一个线程调用deleteLast, 会导致ArrayIndexOfBoundsException异常
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }


    //通过加锁的方式解决
    public static Object getLast2(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            return list.get(lastIndex);
        }

    }

    public static void deleteLast2(Vector list) {
        synchronized (list) {
            int lastIndex = list.size() - 1;
            list.remove(lastIndex);
        }
    }

}
