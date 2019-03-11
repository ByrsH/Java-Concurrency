package org.yrs.concurrency.javaConcurrencyInActionGeek.chapter4;

/**
 * @Author: yangrusheng
 * @Description: 如果被保护资源间有关联关系，那么使用更粗粒度的锁保护所有资源
 * @Date: Created in 23:25 2019/3/11
 * @Modified By:
 */
public class Account3 {
    private int balance;
    //转账
    void transfer(Account3 target, int amt) {
        //有性能问题
        synchronized (Account3.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}
