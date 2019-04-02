package org.yrs.concurrency.javaConcurrencyInActionGeek.chapter6;

import java.util.List;

/**
 * @Author: yangrusheng
 * @Description: 等待-通知机制
 * @Date: Created in 9:38 2019/4/2
 * @Modified By:
 */
public class Allocator {

    private List<Object> als;

    //一次申请所有资源
    synchronized void apply(Object from, Object to) {
        // 经典写法
        while (als.contains(from) || als.contains(to)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        als.add(from);
        als.add(to);
    }

    //归还资源
    synchronized void free(Object from, Object to) {
        als.remove(from);
        als.remove(to);
        notifyAll();
    }

}
