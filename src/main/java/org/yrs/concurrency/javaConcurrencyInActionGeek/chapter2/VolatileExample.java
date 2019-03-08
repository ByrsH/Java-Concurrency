package org.yrs.concurrency.javaConcurrencyInActionGeek.chapter2;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 9:27 2019/3/6
 * @Modified By:
 */
// 以下代码来源于【参考 1】
class VolatileExample {
    int x = 0;
    volatile boolean v = false;
    public void writer() {
        x = 42;
        v = true;
    }
    public void reader() {
        if (v == true) {
            // 这里 x 会是多少呢？
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        final VolatileExample volatileExample = new VolatileExample();

        Thread th1 = new Thread(()->{
            volatileExample.writer();
        });

        Thread th2 = new Thread(()->{
            volatileExample.reader();
        });

        //等待两个线程执行结束
        try {
            th1.start();
            th1.join();
            th2.start();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

