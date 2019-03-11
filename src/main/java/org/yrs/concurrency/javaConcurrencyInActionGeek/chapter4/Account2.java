package org.yrs.concurrency.javaConcurrencyInActionGeek.chapter4;

/**
 * @Author: yangrusheng
 * @Description: 一个锁保护多个资源，但是会导致性能问题。取款、查看余额、修改密码、查看密码这四个操作都是串行
 * @Date: Created in 8:54 2019/3/11
 * @Modified By:
 */
public class Account2 {
    //账户余额
    private Integer balance;

    //账户密码
    private String password;

    //取款
    synchronized void withdraw(Integer amt) {
        if (this.balance > amt) {
            this.balance -= amt;
        }
    }

    //查看余额
    synchronized Integer getBalance() {
        return balance;
    }

    //更改密码
    synchronized void updatePassword(String pw) {
        this.password = pw;
    }

    //查看密码
    synchronized String getPassword() {
        return password;
    }

}
