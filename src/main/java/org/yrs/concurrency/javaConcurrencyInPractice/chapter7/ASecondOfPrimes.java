package org.yrs.concurrency.javaConcurrencyInPractice.chapter7;

import java.math.BigInteger;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @Author: yangrusheng
 * @Description: 一个仅运行一秒钟的素数生成器
 * @Date: Created in 9:19 2018/11/8
 * @Modified By:
 */
public class ASecondOfPrimes {

    List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }

    public static void main(String[] args) throws InterruptedException {
        ASecondOfPrimes aSecondOfPrimes = new ASecondOfPrimes();
        List<BigInteger> bigIntegerList = aSecondOfPrimes.aSecondOfPrimes();
        System.out.println(bigIntegerList.size());
    }

}
