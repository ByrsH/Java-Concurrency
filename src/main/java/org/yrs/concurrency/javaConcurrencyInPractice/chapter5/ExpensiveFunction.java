package org.yrs.concurrency.javaConcurrencyInPractice.chapter5;

import java.math.BigInteger;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 19:44 2018/10/18
 * @Modified By:
 */
public class ExpensiveFunction implements Computable<String, BigInteger> {
    @Override
    public BigInteger compute(String arg) throws InterruptedException {
        //经过长时间的计算后
        return new BigInteger(arg);
    }
}
