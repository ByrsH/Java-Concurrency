package org.yrs.concurrency.javaConcurrencyInPractice.chapter5;

import java.util.concurrent.*;

import static org.yrs.concurrency.javaConcurrencyInPractice.chapter5.Preloader.launderThrowable;

/**
 * @Author: yangrusheng
 * @Description: 最终实现，使用原子方法putIfAbsent
 * @Date: Created in 20:04 2018/10/18
 * @Modified By:
 */
public class Memoizer<A, V> implements Computable<A, V> {

    private final ConcurrentMap<A, Future<V>> cache = new ConcurrentHashMap<A, Future<V>>();
    private final Computable<A, V> c;

    public Memoizer(Computable<A, V> c) {
        this.c = c;
    }

    @Override
    public V compute(final A arg) throws InterruptedException {
        while (true) {
            Future<V> f = cache.get(arg);
            if (f == null) {
                Callable<V> eval = new Callable<V>() {
                    @Override
                    public V call() throws Exception {
                        return c.compute(arg);
                    }
                };
                FutureTask<V> ft = new FutureTask<V>(eval);
                f = cache.putIfAbsent(arg, ft);
                if (f == null) {
                    f = ft;
                    ft.run();
                }
            }
            try {
                return f.get();
            }catch (CancellationException e) {
                cache.remove(arg, f);
            }catch (ExecutionException e) {
                throw launderThrowable(e.getCause());
            }
        }
    }
}
