package org.yrs.concurrency.javaConcurrencyInPractice.chapter5;

/**
 * @Author: yangrusheng
 * @Description: 使用HashMap和同步机制来初始化缓存
 * @Date: Created in 19:42 2018/10/18
 * @Modified By:
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
