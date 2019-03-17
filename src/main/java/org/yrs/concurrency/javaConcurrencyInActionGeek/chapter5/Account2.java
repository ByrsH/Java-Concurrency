package org.yrs.concurrency.javaConcurrencyInActionGeek.chapter5;

/**
 * @program: Java-Concurrency
 * @description: 破坏循环等待条件，按顺序申请资源
 * @author: yrs
 * @create: 2019-03-17 17:21
 **/
public class Account2 {

    private int id;

    private int balance;

    //转账
    void transfer(Account2 target, int amt) {
        Account2 left = this;
        Account2 right = target;
        if (this.id > target.id) {
            left = target;
            right = this;
        }
        //锁定序号小的账户
        synchronized (left) {
            //锁定序号大的账户
            synchronized (right) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    this.balance += amt;
                }
            }
        }
    }

}
