package org.yrs.concurrency.javaConcurrencyInActionGeek.chapter5;

/**
 * @program: Java-Concurrency
 * @description:
 * @author: yrs
 * @create: 2019-03-17 17:05
 **/
public class Account {
    // actr 应该为单例
    private Allocator actr;
    private int balance;
    //转账
    void transfer(Account target, int amt) {
        //一次性申请转出账户和转入账户，直到成功
        while (!actr.apply(this, target))
            ;
        try {
            //锁定转出账户
            synchronized (this) {
                //锁定转入账户
                synchronized (target) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        } finally {
            actr.free(this, target);
        }
    }
}
