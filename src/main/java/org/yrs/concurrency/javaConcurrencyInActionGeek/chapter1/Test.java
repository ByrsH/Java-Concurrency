package org.yrs.concurrency.javaConcurrencyInActionGeek.chapter1;

/**
 * @Author: yangrusheng
 * @Description: 验证多核场景下的可见性问题
 * @Date: Created in 9:28 2019/3/6
 * @Modified By:
 */
public class Test {
    private long count = 0;

    private void add10k() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() {
        final Test test = new Test();
        //创建两个线程，执行 add() 操作
        Thread th1 = new Thread(()->{
            test.add10k();
        });
        Thread th2 = new Thread(()->{
            test.add10k();
        });
        //启动两个线程
        th1.start();
        th2.start();
        //等待两个线程执行结束
        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return test.count;
    }

    public static void main(String[] args) {
        //值应该在区间 [10000,20000] 上，当出现20000时，可能两个线程操作同一个CPU缓存？？？
        System.out.println(calc());
    }
}
