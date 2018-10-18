package org.yrs.concurrency.javaConcurrencyInPractice.chapter5;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yangrusheng
 * @Description: 用ConcurrentHashMap代替HashMap
 * @Date: Created in 19:50 2018/10/18
 * @Modified By:
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<A, V>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
