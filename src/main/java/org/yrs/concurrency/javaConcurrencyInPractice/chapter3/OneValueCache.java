package org.yrs.concurrency.javaConcurrencyInPractice.chapter3;

import net.jcip.annotations.Immutable;

import java.math.BigInteger;
import java.util.Arrays;

/**
 * @Author: yangrusheng
 * @Description: 对数值及其因数分解结果进行缓存的不可变容器类
 * @Date: Created in 10:20 2018/8/8
 * @Modified By:
 */
@Immutable
public class OneValueCache {
    private final BigInteger lastNumber;
    private final BigInteger[] lastFactors;

    public OneValueCache(BigInteger i, BigInteger[] factors) {
        this.lastNumber = i;
        this.lastFactors = Arrays.copyOf(factors, factors.length);
    }

    public BigInteger[] getFactors(BigInteger i) {
        if (lastFactors == null || !lastNumber.equals(i)) {
            return null;
        }
        else {
            return Arrays.copyOf(lastFactors, lastFactors.length);
        }
    }
}
