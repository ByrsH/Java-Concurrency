package org.yrs.concurrency.javaConcurrencyInPractice.chapter5;

import java.util.Map;
import java.util.concurrent.*;

import static org.yrs.concurrency.javaConcurrencyInPractice.chapter5.Preloader.launderThrowable;

/**
 * @Author: yangrusheng
 * @Description: 基于FutureTask的Memoizing封装器
 * @Date: Created in 19:53 2018/10/18
 * @Modified By:
 */
public class Memeizer3<A, V> implements Computable<A, V> {

    private final Map<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memeizer3(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        Future<V> f = cache.get(arg);
        if (f == null) {
            Callable<V> eval = new Callable<V>() {
                @Override
                public V call() throws Exception {
                    return c.compute(arg);
                }
            };
            FutureTask<V> ft = new FutureTask<V>(eval);
            f = ft;
            cache.put(arg, ft);
            ft.run(); //在这里将调用c.compute()
        }
        try {
            return f.get();
        } catch (ExecutionException e) {
            throw launderThrowable(e.getCause());
        }
    }
}
